public class LocalPoluido {

    // Atributos
    private String coordenadas;
    private int quantidadePlastico;
    private String descricao;

    // Construtores
    public LocalPoluido(String coordenadas, int quantidadePlastico) {
        this.coordenadas = coordenadas;
        this.quantidadePlastico = quantidadePlastico;
        this.descricao = "Plástico comum";
    }

    public LocalPoluido(String coordenadas, String descricao) {
        this.coordenadas = coordenadas;
        this.quantidadePlastico = 1;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Coordenadas: " + coordenadas + " | " + "Quantidade de Plástico: " + quantidadePlastico + " | " + "Descrição: " + descricao;
    }

    // Getters e Setters
    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getQuantidadePlastico() {
        return quantidadePlastico;
    }

    public void setQuantidadePlastico(int quantidadePlastico) {
        this.quantidadePlastico = quantidadePlastico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
