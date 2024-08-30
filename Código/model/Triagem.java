package model;

public class Triagem {

    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String cpf;
    private int pacienteId;
    private String pressao;
    private double temperatura;
    private String sintomas;
    private int senhaAtendimento;

    // Construtor padrão
    public Triagem() {
    }

    // Construtor 
    public Triagem(int id, int pacienteId, String pressao, double temperatura, String sintomas, String nome, int idade, String sexo, String cpf, int senhaAtendimento) {
        this.id = id;
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.pacienteId = pacienteId;
        this.pressao = pressao;
        this.temperatura = temperatura;
        this.sintomas = sintomas;
        this.senhaAtendimento = senhaAtendimento;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
}
