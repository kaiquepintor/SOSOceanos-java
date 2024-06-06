package br.com.fiap.sosoceanos.usuario;

public class Usuario {

    // Atributos
    private String nome;
    private String email;
    private String senha;

    // Construtores
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Usuario() {}

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método para verificar senha
    public boolean verificarSenha(String senha) {

        return this.senha.equals(senha);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email;
    }
}

