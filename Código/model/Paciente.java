package model;

public class Paciente {

    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String cpf;
    private int senhaAtendimento;

    // Construtor padrão
    public Paciente() {
    }
    
    // Construtor

    public Paciente(int id, String nome, int idade, String sexo, String cpf, int senhaAtendimento) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.senhaAtendimento = senhaAtendimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getSenhaAtendimento() {
        return senhaAtendimento;
    }

    public void setSenhaAtendimento(int senhaAtendimento) {
        this.senhaAtendimento = senhaAtendimento;
    }
}
