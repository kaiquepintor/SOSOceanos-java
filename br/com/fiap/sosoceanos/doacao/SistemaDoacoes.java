package br.com.fiap.sosoceanos.doacao;

import java.util.ArrayList;
import java.util.List;

public class SistemaDoacoes {

    // Atributos
    private List<Doacao> doacoes;

    public SistemaDoacoes() {
        this.doacoes = new ArrayList<>();
    }

    // Método para registrar doação
    public void registrarDoacao(String ong, double valor, String usuario) {
        Doacao doacao = new Doacao(ong, valor, usuario);
        doacoes.add(doacao);
    }
}
