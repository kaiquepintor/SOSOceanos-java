import java.util.ArrayList;
import java.util.List;

public class Drone extends VeiculoAereo {

    // Construtores
    public Drone(String id, String modelo, double bateria) {
        super(id, modelo, bateria);
    }

    @Override
    public List<String> captarImagem() {

        // Simulação de uma captura de imagem
        List<String> pixelsImagem = new ArrayList<>();
        pixelsImagem.add("agua");
        pixelsImagem.add("agua");
        pixelsImagem.add("plastico");
        pixelsImagem.add("plastico");
        pixelsImagem.add("agua");
        pixelsImagem.add("plastico");
        pixelsImagem.add("agua");
        return pixelsImagem;
    }

    @Override
    public String obterCoordenadas() {

        // Simulação de uma obtenção de coordenadas
        return "37.7749,-122.4194";
    }

    // Método sobrescrito de VeiculoAereo
    @Override
    public String toString() {
        return "DRONE ID: " + id + "\nMODELO: " + modelo + "\nBATERIA: " + bateria;
    }
}
