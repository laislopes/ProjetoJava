/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Codigo.PessoaFisica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class DAOPessoaFisica extends DAOBase<PessoaFisica> {
    private final DAOCliente daoCliente = new DAOCliente();
    
    @Override
    public void deleteById(int id){
        super.deleteById(id);
        daoCliente.deleteById(id);
    }
    @Override
    public int add(PessoaFisica entity){
        int id = daoCliente.add(entity.getCliente());
        entity.setId(id);
        return super.add(entity);
    }
    @Override
    public void update(PessoaFisica entity){
        super.update(entity);
        daoCliente.update(entity.getCliente());
    }
    @Override
    public ArrayList<PessoaFisica> getAll(String whereCondition){
        ArrayList<PessoaFisica> list = super.getAll(whereCondition);
        for (int i = 0; i < list.size(); i++) 
            list.get(i).setCliente(daoCliente.getById(list.get(i).getId()));
        
        return list;
    }
    @Override
    public PessoaFisica getById(int id){
        PessoaFisica pessoaFisica = super.getById(id);
        pessoaFisica.setCliente(daoCliente.getById(id));
        return pessoaFisica;
    }
    @Override
    protected String insertCommand() {
        return "insert into PessoasFisicas (ClienteID, Nome, CPF, Celular, Sexo)" 
                +"values (?,?,?,?,?)";
    }

    @Override
    protected String updateCommand() {
        return "update PessoasFisicas set ClienteID = ?, Nome = ?, CPF = ?, Celular = ?, Sexo = ? "
                +"where ClienteID = ?";
    }

    @Override
    protected void setStatement(PreparedStatement stm, PessoaFisica pessoaFisica) throws SQLException {
        stm.setString(1, Integer.toString(pessoaFisica.getId()));
        stm.setString(2, pessoaFisica.getNome());
        stm.setString(3, pessoaFisica.getCPF());
        stm.setString(4, pessoaFisica.getCelular());
        stm.setInt(5, pessoaFisica.getSexo());
    }

    @Override
    protected String getTableName() {
        return "PessoasFisicas";
    }

    @Override
    protected PessoaFisica mapResultSetToObject(ResultSet rs) throws SQLException, ParseException {
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setId(Integer.parseInt(rs.getString("ClienteID")));
        pessoaFisica.setNome(rs.getString("Nome"));
        pessoaFisica.setCPF(rs.getString("CPF"));
        pessoaFisica.setCelular(rs.getString("Celular"));
        pessoaFisica.setSexo(Integer.parseInt(rs.getString("Sexo")));
        
        return pessoaFisica;
    }

    @Override
    protected void setIdIntoStatment(PreparedStatement stm, PessoaFisica obj) throws SQLException {
        stm.setInt(6, obj.getId());
    }
    
}
