package Codigo;

import java.util.ArrayList;





public class PessoaJuridica extends Pessoa {
    
    private static int id = 0;
    private ArrayList<Integer> idClientePJ;
    private String CNPJ;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private String site;
    
    public PessoaJuridica(String CNPJ, ArrayList<Integer> idClientePJ ){
        
        this.CNPJ = CNPJ;
        id++;
        this.idClientePJ = idClientePJ;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public void setIDCliente(){
     
     idClientePJ.add(id);
     
   }
     public int getIDCliente(int linha){
     
     
     return idClientePJ.get(linha);
   }
         
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getSite() {
        return this.site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    
}
