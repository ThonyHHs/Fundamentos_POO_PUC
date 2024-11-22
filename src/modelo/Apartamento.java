package modelo;

public class Apartamento extends Financiamento{
    // Atributos
    private int numeroVagas;
    private int numeroAndar;

    // Construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagas, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagas = numeroVagas;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() * getTaxaJurosMensal()) / (1 - Math.pow(1+getTaxaJurosMensal(), -getPrazoFinanciamentoMeses()));
    }

    //region Getters
    public int getNumeroVagas() {
        return numeroVagas;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }
    //endregion
}