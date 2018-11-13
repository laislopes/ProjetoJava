package Codigo;



 public abstract class Pessoa {
    
     
     private String endereco;
     private String numero;
     private String cidade;
     private String uf;
     private String bairro;
     private String cep;
     private String telefone;
     private String email;
     private String dataDoCadastro;
    
    
    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataDoCadastro() {
        return this.dataDoCadastro;
    }

    public void setDataDoCadastro(String dataDoCadastro) {
        this.dataDoCadastro = dataDoCadastro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    
    
    
    
     
     
}
