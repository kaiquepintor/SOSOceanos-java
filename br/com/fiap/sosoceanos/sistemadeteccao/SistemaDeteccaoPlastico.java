package br.com.fiap.sosoceanos.sistemadeteccao;

import br.com.fiap.sosoceanos.drone.Drone;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeteccaoPlastico {

    private List<LocalPoluido> locaisPoluidos = new ArrayList<>();

    // Método para detectar plastico
    public boolean detectarPlastico(List<String> pixelsImagem) {
        for (String pixel : pixelsImagem) {
            if (pixel.equals("plastico")) {
                return true;
            }
        }
        return false;
    }

    // Método para contar a quantidade de plástico na imagem
    public int contarPlastico(List<String> pixelsImagem) {
        int quantidadePlastico = 0;
        for (String pixel : pixelsImagem) {
            if (pixel.equals("plastico")) {
                quantidadePlastico++;
            }
        }
        return quantidadePlastico;
    }

    // Método para registrar local poluido
    public void registrarLocalPoluido(String coordenadas, int quantidadePlastico) {
        LocalPoluido local = new LocalPoluido(coordenadas, quantidadePlastico);
        locaisPoluidos.add(local);
    }

    public void registrarLocalPoluido(String coordenadas, String descricao) {
        LocalPoluido local = new LocalPoluido(coordenadas, descricao);
        locaisPoluidos.add(local);
    }

    public void registrarLocalPoluido(String coordenadas) {
        registrarLocalPoluido(coordenadas, 1);
    }

    // Método para gerar relatório
    public String gerarRelatorioPoluicao() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Locais Poluídos:\n");
        for (LocalPoluido local : locaisPoluidos) {
            relatorio.append(local.toString()).append("\n");
        }
        return relatorio.toString();
    }

}
