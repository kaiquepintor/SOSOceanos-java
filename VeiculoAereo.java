import java.util.List;

public abstract class VeiculoAereo {

    // Atributos
    protected String id;
    protected String modelo;
    protected double bateria;

    // Construtores
    public VeiculoAereo(String id, String modelo, double bateria) {
        this.id = id;
        this.modelo = modelo;
        this.bateria = bateria;
    }

    //
    public abstract List<String> captarImagem();
    public abstract String obterCoordenadas();

    @Override
    public String toString() {
        return "id= " + id + ", modelo= " + modelo + ", bateria= " + bateria;
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

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }
}
