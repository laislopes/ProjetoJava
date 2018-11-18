package Codigo;


public class PessoaFisica {
    private Integer id;
    private String nome;
    private String cpf;
    private String celular;
    private int sexo;
    private Cliente cliente = new Cliente();

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return this.cpf;
    }
    public void setCPF(String CPF) {
        this.cpf = CPF;
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
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
}
