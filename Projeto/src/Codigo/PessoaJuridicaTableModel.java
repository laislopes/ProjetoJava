
package Codigo;

import InterfaceGrafica.CadastroPessoaJuridica;
import dao.DAOPessoaJuridica;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class PessoaJuridicaTableModel extends AbstractTableModel{
    
    private DAOPessoaJuridica daoPJ = new DAOPessoaJuridica();
    List<PessoaJuridica> dados;
    
    public PessoaJuridicaTableModel(){
        dados = daoPJ.getAll("");
        if(daoPJ.hasError()) JOptionPane.showMessageDialog(null, daoPJ.getError());
    }
    String[] colunas = {"ID","Razão Social", "CNPJ", "Inscrição Estadual", "Telefone", "E-mail", "Data do Cadastro"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getRazaoSocial();
            case 2:
                return dados.get(linha).getCNPJ();
            case 3:
                return dados.get(linha).getInscricaoEstadual();
            case 4:
                return dados.get(linha).getCliente().getTelefone();
            case 5:
                return dados.get(linha).getCliente().getEmail();
            case 6:
                return dados.get(linha).getCliente().getDataDoCadastro();
             
                
        }
        return null;
        }
    
    public void refresh(){
        
        this.dados = daoPJ.getAll("");
        this.fireTableDataChanged();
        
    }
    
    public void buscar(List<PessoaJuridica> dados){
        
        this.dados = dados;
        this.fireTableDataChanged();
        
    }
     public void removeRow(int linha){
        
        daoPJ.deleteById(dados.get(linha).getId());
        this.dados = daoPJ.getAll("");
        this.fireTableRowsDeleted(linha, linha);
        
    }
     public void updateRow(int linha,CadastroPessoaJuridica cadastroPessoaJuridica){
        
        cadastroPessoaJuridica.atualizarCadastro(dados.get(linha));
        
    }
    
    
}
