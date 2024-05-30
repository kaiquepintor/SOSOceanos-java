import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Apresentação do site
        JOptionPane.showMessageDialog(null, "Bem vindo ao SOS Oceans");
        // Instancia de drone
        Drone drone = new Drone("d001", "BJK", 96.2);

        // Instancia do sistema de detecção de plastico
        SistemaDeteccaoPlastico sistema = new SistemaDeteccaoPlastico();

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

                    // Gerar e exibir relatório de poluição
                    String relatorio = sistema.gerarRelatorioPoluicao();
                    JOptionPane.showMessageDialog(null, relatorio);

                    // Exibir informações do drone
                    JOptionPane.showMessageDialog(null, drone.toString());
                    break;

                case 2:
                    int opcaoOng;
                    do {
                        opcaoOng = Integer.parseInt(JOptionPane.showInputDialog("ONGS Parceiras: " +
                                "\n1 - Ong 1 " +
                                "\n2 - Ong 2 " +
                                "\n3 - Voltar"));

                        switch (opcaoOng) {
                            case 1:


                            case 2:


                            case 3:
                                break;

                        }
                    } while (opcaoOng != 3);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o SOS Oceans");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }

        } while (opcao != 3);

    }

}
