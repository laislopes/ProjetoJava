/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Codigo.PessoaJuridica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class DAOPessoaJuridica extends DAOBase<PessoaJuridica>{
    private final DAOCliente daoCliente = new DAOCliente();
    
    @Override
    public void deleteById(int id){
        super.deleteById(id);
        daoCliente.deleteById(id);
    }
    @Override
    public int add(PessoaJuridica entity){
        int id = daoCliente.add(entity.getCliente());
        entity.setId(id);
        return super.add(entity);
    }
    @Override
    public void update(PessoaJuridica entity){
        super.update(entity);
        daoCliente.update(entity.getCliente());
    }
    @Override
    public PessoaJuridica getById(int id){
        PessoaJuridica pessoaJuridica = super.getById(id);
        pessoaJuridica.setCliente(daoCliente.getById(id));
        return pessoaJuridica;
    }
    @Override
    public ArrayList<PessoaJuridica> getAll(String whereCondition){
        ArrayList<PessoaJuridica> list = super.getAll(whereCondition);
        for (int i = 0; i < list.size(); i++) 
            list.get(i).setCliente(daoCliente.getById(list.get(i).getId()));
        
        return list;
    }
    @Override
    protected String insertCommand() {
        return "insert into PessoasJuridicas (ClienteID, RazaoSocial, CNPJ, NomeFantasia, InscricaoEstadual, Site)" 
                +"values (?,?,?,?,?,?)";
    }

    @Override
    protected String updateCommand() {
        return "update PessoasJuridicas set ClienteID = ?, RazaoSocial = ?, CNPJ = ?, NomeFantasia = ?, InscricaoEstadual = ?,Site = ? "
                +"where ClienteID = ?";
    }

    @Override
    protected void setStatement(PreparedStatement stm, PessoaJuridica pessoaJuridica) throws SQLException {
        stm.setString(1, Integer.toString(pessoaJuridica.getId()));
        stm.setString(2, pessoaJuridica.getRazaoSocial());
        stm.setString(3, pessoaJuridica.getCNPJ());
        stm.setString(4, pessoaJuridica.getNomeFantasia());
        stm.setString(5, pessoaJuridica.getInscricaoEstadual());
        stm.setString(6, pessoaJuridica.getSite());
    }

    @Override
    protected String getTableName() {
        return "PessoasJuridicas";
    }

    @Override
    protected PessoaJuridica mapResultSetToObject(ResultSet rs) throws SQLException, ParseException {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setId(Integer.parseInt(rs.getString("ClienteID")));
        pessoaJuridica.setRazaoSocial(rs.getString("RazaoSocial"));
        pessoaJuridica.setCNPJ(rs.getString("CNPJ"));
        pessoaJuridica.setNomeFantasia(rs.getString("NomeFantasia"));
        pessoaJuridica.setInscricaoEstadual(rs.getString("InscricaoEstadual"));
        
        return pessoaJuridica;
    }

    @Override
    protected void setIdIntoStatment(PreparedStatement stm, PessoaJuridica obj) throws SQLException {
        stm.setInt(7, obj.getId());
    }
    
}
