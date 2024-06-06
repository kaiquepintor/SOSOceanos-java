package br.com.fiap.sosoceanos.drone;

import java.util.ArrayList;
import java.util.List;

public class Drone extends VeiculoAereo {

    // Atributos
    private double bateria;

    // Construtores
    public Drone(String id, String modelo, double bateria) {
        super(id, modelo);
        this.bateria = bateria;
    }

    // Simulação de uma captura de imagem
    public List<String> captarImagem() {

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

    // Simulação de uma obtenção de coordenadas
    public String obterCoordenadas() {

        return "37.7749,-122.4194";
    }

    // Método sobrescrito de VeiculoAereo
    @Override
    public String toString() {
        return "DRONE ID: " + id + "\nMODELO: " + modelo + "\nBATERIA: " + bateria;
    }
}
