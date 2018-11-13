
package Codigo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PessoaJuridicaTableModel extends AbstractTableModel{
    
    List<PessoaJuridica> dados = new ArrayList <>();
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
                return dados.get(linha).getIDCliente(linha);
            case 1:
                return dados.get(linha).getRazaoSocial();
            case 2:
                return dados.get(linha).getCNPJ();
            case 3:
                return dados.get(linha).getInscricaoEstadual();
            case 4:
                return dados.get(linha).getTelefone();
            case 5:
                return dados.get(linha).getEmail();
            case 6:
                return dados.get(linha).getDataDoCadastro();
             
                
        }
        return null;
        }
    
    public void addRow(PessoaJuridica PJ){
        
        this.dados.add(PJ);
        this.fireTableDataChanged();
        
    }
    
     public void removeRow(int linha){
        
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        
    }
    
    
}
