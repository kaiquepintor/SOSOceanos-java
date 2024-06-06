package br.com.fiap.sosoceanos.doacao;

public class Doacao {

    // Atributos
    private String ong;
    private double valor;
    private String usuario;

    // Construtores
    public Doacao(String ong, double valor, String usuario) {
        this.ong = ong;
        this.valor = valor;
        this.usuario = usuario;
    }

    public Doacao() {}

    @Override
    public String toString() {
        return "ONG: " + ong + ", Valor: R$ " + valor + ", Usuário: " + usuario;
    }

   // Getters e Setters
    public String getOng() {
        return ong;
    }

    public void setOng(String ong) {
        this.ong = ong;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
