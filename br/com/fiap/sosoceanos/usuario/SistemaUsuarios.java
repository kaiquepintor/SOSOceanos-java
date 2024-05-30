package br.com.fiap.sosoceanos.usuario;

import java.util.ArrayList;
import java.util.List;

public class SistemaUsuarios {
    private List<Usuario> usuarios;

    public SistemaUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    // Método para cadastrar usuário
    public boolean cadastrarUsuario(String nome, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return false; // Email já cadastrado
            }
        }
        usuarios.add(new Usuario(nome, email, senha));
        return true;
    }

    // Método para login do usuário
    public Usuario loginUsuario(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.verificarSenha(senha)) {
                return usuario; // Login bem-sucedido
            }
        }
        return null; // Falha no login
    }
}

