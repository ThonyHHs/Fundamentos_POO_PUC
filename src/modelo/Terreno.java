package modelo;

public class Terreno extends Financiamento {
    // Construtor
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }
}
