/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Codigo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class DAOCliente extends DAOBase<Cliente> {

    @Override
    protected String insertCommand() {
        return "insert into clientes (ClienteID, Endereco, Numero, Cidade, Bairro, Estado, CEP, Telefone, Email, DataDoCadastro)" 
                +"values (0,?,?,?,?,?,?,?,?,current_timestamp)";
    }
    
    @Override
    protected String updateCommand() {
        return "update clientes set Endereco = ?, Numero = ?, Cidade = ?, Bairro = ? "
               +"Estado = ?, CEP = ?, Telefone = ?, Email = ? where ClienteID = ?";
    }
    @Override
    protected void setStatement(PreparedStatement stm, Cliente cliente) throws SQLException{
            stm.setString(1, cliente.getEndereco());
            stm.setString(2, Integer.toString(cliente.getNumero()));
            stm.setString(3, cliente.getCidade());
            stm.setString(4, cliente.getBairro());
            stm.setString(5, cliente.getEstado());
            stm.setString(6, cliente.getCep());
            stm.setString(7, cliente.getTelefone());
            stm.setString(8, cliente.getEmail());
    }

    @Override
    protected String getTableName() {
        return "Clientes";
    }

    @Override
    protected Cliente mapResultSetToObject(ResultSet rs) throws SQLException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(rs.getString("ClienteID")));
        cliente.setEndereco(rs.getString("Endereco"));
        cliente.setNumero(Integer.parseInt(rs.getString("Numero")));
        cliente.setCidade(rs.getString("Cidade"));
        cliente.setBairro(rs.getString("Bairro"));
        cliente.setEstado(rs.getString("Estado"));
        cliente.setCep(rs.getString("CEP"));
        cliente.setTelefone(rs.getString("Telefone"));
        cliente.setEmail(rs.getString("Email"));
        cliente.setDataDoCadastro(format.parse(rs.getString("DataDoCadastro")));
        
        return cliente;
    }

    @Override
    protected void setIdIntoStatment(PreparedStatement stm, Cliente obj) throws SQLException {
        stm.setInt(9,obj.getId());
    }

    
}