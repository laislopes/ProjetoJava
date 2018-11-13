package Codigo;

import java.util.ArrayList;



public class PessoaFisica extends Pessoa {
    
    private static int id = 0;
    private ArrayList<Integer> idClientePF;
    private String nome;
    private String CPF;
    private int sexo;
    private String celular;
    
    
    
    public PessoaFisica(String CPF,ArrayList<Integer> idClientePF ){
        
        this.CPF = CPF;
        id++;
        this.idClientePF = idClientePF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
   
    public void setIDCliente(){
        idClientePF.add(id);
   }
   public int getIDCliente(int linha){
       return idClientePF.get(linha);
   }

    public int getSexo() {
        return this.sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
   
   
    
            
}
