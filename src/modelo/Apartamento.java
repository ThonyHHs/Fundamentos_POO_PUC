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

    //region Métodos
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() * getTaxaJurosMensal()) / (1 - Math.pow(1+getTaxaJurosMensal(), -getPrazoFinanciamentoMeses()));
    }

    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        // Detalhes sobre o imóvel
        detalhes.append(String.format("APARTAMENTO%n"));
        detalhes.append(String.format("----------------------------------------------%n"));
        detalhes.append(String.format("%-23s: R$ %.2f%n", "Valor do imóvel", getValorImovel()));
        detalhes.append(String.format("%-23s: %d%n", "Número do Andar", this.numeroAndar));
        detalhes.append(String.format("%-23s: %d%n", "Número de Vagas", this.numeroVagas));

        // Detalhes sobre o financiamento
        detalhes.append(super.toString());

        return detalhes.toString();
    }
    //endregion

    //region Getters
    public int getNumeroVagas() {
        return numeroVagas;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }
    //endregion
}