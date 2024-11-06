package modelo;

public class Apartamento extends Financiamento{
    // Construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12;
        double prazoMeses = getPrazoFinanciamento() * 12;

        return (getValorImovel() * taxaMensal * Math.pow(1+taxaMensal, prazoMeses)) / Math.pow(1+taxaMensal, prazoMeses-1);
    }
}
