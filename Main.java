import br.com.fiap.sosoceanos.drone.Drone;
import br.com.fiap.sosoceanos.sistemadeteccao.SistemaDeteccaoPlastico;
import br.com.fiap.sosoceanos.usuario.SistemaUsuarios;
import br.com.fiap.sosoceanos.usuario.Usuario;
import br.com.fiap.sosoceanos.doacao.SistemaDoacoes;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instancia do drone
        Drone drone = new Drone("d001", "BJK", 96.2);

        // Instancia do sistema de detecção de plastico
        SistemaDeteccaoPlastico sistema = new SistemaDeteccaoPlastico();

        // Instancia do sistema de usuários
        SistemaUsuarios sistemaUsuarios = new SistemaUsuarios();

        // Instancia do sistema de doações
        SistemaDoacoes sistemaDoacoes = new SistemaDoacoes();

        Usuario usuarioAtual = null;

        // Área de Cadastro e Login
        int opcaoCadastro;
        boolean loggedIn = false;
        do {
            opcaoCadastro = Integer.parseInt(JOptionPane.showInputDialog("Digite qual opção deseja acessar: " +
                    "\n1 - Cadastrar " +
                    "\n2 - Login " +
                    "\n3 - Sair"));

            switch (opcaoCadastro) {
                case 1:
                    JTextField nomeField = new JTextField();
                    JTextField emailField = new JTextField();
                    JPasswordField passwordField1 = new JPasswordField();
                    Object[] areaCadastro = {
                            "Digite seu nome:", nomeField,
                            "Digite seu email:", emailField,
                            "Digite sua senha:", passwordField1
                    };
                    int optionCadastro = JOptionPane.showConfirmDialog(null, areaCadastro, "Cadastro", JOptionPane.OK_CANCEL_OPTION);
                    if (optionCadastro == JOptionPane.OK_OPTION) {
                        String nome = nomeField.getText();
                        String email = emailField.getText();
                        String senha = new String(passwordField1.getPassword());

                        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                        } else {
                            if (sistemaUsuarios.cadastrarUsuario(nome, email, senha)) {
                                JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Email já cadastrado!");
                            }
                        }
                    }
                    break;

                case 2:
                    emailField = new JTextField();
                    JPasswordField passwordField2 = new JPasswordField();
                    Object[] areaLogin = {
                            "Digite seu email:", emailField,
                            "Digite sua senha:", passwordField2
                    };
                    int optionLogin = JOptionPane.showConfirmDialog(null, areaLogin, "Login", JOptionPane.OK_CANCEL_OPTION);
                    if (optionLogin == JOptionPane.OK_OPTION) {
                        String email = emailField.getText();
                        String senha = new String(passwordField2.getPassword());

                        usuarioAtual = sistemaUsuarios.loginUsuario(email, senha);

                        if (usuarioAtual != null) {
                            JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                            loggedIn = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
                        }
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o SOS Oceans");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        } while (!loggedIn);

        // Apresentação do site
        JOptionPane.showMessageDialog(null, "Bem vindo ao SOS Oceanos");

        // Área do Menu Principal
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite qual opção deseja acessar: " +
                    "\n1 - Relatório de Poluição por Drone " +
                    "\n2 - Doar para ONGS " +
                    "\n3 - Sair"));

            switch (opcao) {
                case 1:
                    // Processar imagem do drone
                    List<String> imagem = drone.captarImagem();
                    boolean plasticoDetectado = sistema.detectarPlastico(imagem);

                    if (plasticoDetectado) {
                        String coordenadas = drone.obterCoordenadas();
                        int quantidadePlastico = sistema.contarPlastico(imagem);
                        sistema.registrarLocalPoluido(coordenadas, quantidadePlastico);
                    }

                    // Gerar relatório de poluição
                    String relatorio = sistema.gerarRelatorioPoluicao();
                    JOptionPane.showMessageDialog(null, relatorio);

                    // Exibir informações do drone
                    JOptionPane.showMessageDialog(null, drone.toString());
                    break;

                case 2:
                    int opcaoOng;
                    do {
                        opcaoOng = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que deseja acessar: " +
                                "\n1 - CoralGuardians: Preservação de recifes de corais " +
                                "\n2 - CleanWave: Limpeza de lixo plástico dos oceanos " +
                                "\n3 - Voltar"));

                        switch (opcaoOng) {
                            case 1:
                                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite quanto deseja doar:"));
                                sistemaDoacoes.registrarDoacao("CoralGuardians", valor, usuarioAtual.getNome());
                                JOptionPane.showMessageDialog(null, "Obrigado(a), " + usuarioAtual.getNome() +
                                        ". Você doou R$" + valor + " para a CoralGuardians!");
                                break;

                            case 2:
                                valor = Double.parseDouble(JOptionPane.showInputDialog("Digite quanto deseja doar:"));
                                sistemaDoacoes.registrarDoacao("CleanWave", valor, usuarioAtual.getNome());
                                JOptionPane.showMessageDialog(null, "Obrigado(a), " + usuarioAtual.getNome() +
                                        ". Você doou R$" + valor + " para a CleanWave!");
                                break;

                            case 3:
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma opção válida.");
                                break;
                        }
                    } while (opcaoOng != 3);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o SOS Oceanos");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }

        } while (opcao != 3);
    }
}
