package model;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String areaAtuacao;

    // Construtor padrão
    public Usuario() {
    }

    // Construtor
    public Usuario(int id, String login, String senha, String areaAtuacao) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.areaAtuacao = areaAtuacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}
