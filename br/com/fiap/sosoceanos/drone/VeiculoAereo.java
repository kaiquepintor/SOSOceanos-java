package br.com.fiap.sosoceanos.drone;

public abstract class VeiculoAereo {

    // Atributos
    protected String id;
    protected String modelo;

    // Construtores
    public VeiculoAereo(String id, String modelo) {
        this.id = id;
        this.modelo = modelo;
    }

    public VeiculoAereo() {}

    @Override
    public String toString() {
        return "id= " + id + ", modelo= " + modelo;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
