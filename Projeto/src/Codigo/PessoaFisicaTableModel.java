
package Codigo;

import InterfaceGrafica.CadastroPessoaFisica;
import dao.DAOPessoaFisica;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PessoaFisicaTableModel extends AbstractTableModel{
    
    private DAOPessoaFisica daoPF = new DAOPessoaFisica();
    List<PessoaFisica> dados = daoPF.getAll("");
    String[] colunas = {"ID","Nome", "CPF","Celular","Data do Cadastro"};
    
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
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getCPF();
            case 3:
                return dados.get(linha).getCelular();
            case 4:
                return dados.get(linha).getCliente().getDataDoCadastro();
                
        }
        return null;
    }
    
    public void refresh(){
        
        this.dados = daoPF.getAll("");
        this.fireTableDataChanged();
        
    }
    
     public void buscar(List<PessoaFisica> dados){
        
        this.dados = dados;
        this.fireTableDataChanged();
        
    }
     
      public void updateRow(int linha,CadastroPessoaFisica cadastroPessoaFisica){
        
        cadastroPessoaFisica.atualizarCadastro(dados.get(linha));
        
    }
    
    public void removeRow(int linha){
        daoPF.deleteById(dados.get(linha).getId());
        this.dados = daoPF.getAll("");
        this.fireTableRowsDeleted(linha, linha);
        
    }
    
    
}