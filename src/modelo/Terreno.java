package modelo;

public class Terreno extends Financiamento {
    private String zona;

    // Construtor
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.zona = zona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }

    //region Getters
    public String getZona() {
        return zona;
    }
    //endregion
}