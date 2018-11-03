
package Codigo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PessoaFisicaTableModel extends AbstractTableModel{
    
    List<PessoaFisica> dados = new ArrayList <>();
    String[] colunas = {"ID","Nome", "CPF","Telefone","Celular","E-mail","Data do Cadastro"};

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
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getCPF();
            case 3:
                return dados.get(linha).getTelefone();
            case 4:
                return dados.get(linha).getCelular();
            case 5:
                return dados.get(linha).getEmail();
            case 6:
                return dados.get(linha).getDataDoCadastro();
            
                
        }
        return null;
        }
    
    public void addRow(PessoaFisica PF){
        
        this.dados.add(PF);
        this.fireTableDataChanged();
        
    }
    
    public void removeRow(int linha){
        
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        
    }
    
    
}
