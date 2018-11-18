/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public abstract class DAOBase<T> {
    
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/bytebank";
    private String user = "admin";
    private String password = "admin";
    private String erro = "";
    private Connection connection;
    
    private void getConnection() {
        try {
            erro = "";
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            erro += "\n"+ e.getMessage();
            connection = null;
        }
        
    }
    
    private void closeConnection(){
        if(connection != null)
            try {
                connection.close();
        } catch (SQLException e) {
            erro += "\n"+ e.getMessage();
        }
    }
    
    protected abstract String insertCommand();
    
    protected abstract String updateCommand();
    
    protected abstract void setStatement(PreparedStatement stm, T obj) throws SQLException;
    
    protected abstract String getTableName();
    
    protected abstract T mapResultSetToObject(ResultSet rs) throws SQLException, ParseException;
    
    protected abstract void setIdIntoStatment(PreparedStatement stm, T obj) throws SQLException;
    
    
    public String getError(){
        return erro;
    }
    
    public boolean hasError(){
        return !"".equals(erro);
    }
   
    public void deleteById(int id){
        getConnection();
            String sql = "delete from "+getTableName()+" where ClienteID = ?";
            
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                erro += "\n"+ e.getMessage();
        }
        closeConnection();
    }
    
    public int add(T entity){
        int savedId = 0;
            getConnection();
            String sql = insertCommand();
            
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                setStatement(stmt, entity);
                stmt.execute();
                
                sql = "SELECT MAX(ClienteID) as LAST_INSERTED_ID FROM "+getTableName();
                stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next())
                    savedId = Integer.parseInt(rs.getString("LAST_INSERTED_ID"));
                
                stmt.close();
            } catch (SQLException e) {
                erro += "\n"+ e.getMessage();
        }
        closeConnection();
        return savedId;
    }
    
    public void update(T entity){
            int savedId = 0;
            getConnection();
            String sql = updateCommand();
            
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                setStatement(stmt, entity);
                setIdIntoStatment(stmt, entity);
            
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                erro += "\n"+ e.getMessage();
        }
        closeConnection();
    }
    
    public T getById(int id){
        ArrayList<T> list = getAll("ClienteID = "+id);
        return list.get(0);
    }
    
    public ArrayList<T> getAll(String whereCondition){
        getConnection();
        ArrayList<T> list = new ArrayList<T>();
        try {
            if(!"".equals(whereCondition)) whereCondition = " where "+whereCondition;
            PreparedStatement stmt = connection.prepareStatement("select * from " + getTableName()+whereCondition);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                T newObj = mapResultSetToObject(rs);
                list.add(newObj);
            }

            stmt.close();
            closeConnection();
        } catch (SQLException | ParseException e) {
            erro += "\n"+ e.getMessage();
        }
        return list;
    }
    
}
