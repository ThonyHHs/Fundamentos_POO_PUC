package modelo;

import util.Zonas;

public class Terreno extends Financiamento { 
    private Zonas zona;

    // Construtor
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJuros, Zonas zona) {
        super(valorImovel, prazoFinanciamento, taxaJuros);
        this.zona = zona;
    }

    //region Métodos
    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }

    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        // Detalhes sobre o imóvel
        detalhes.append(String.format("TERRENO%n"));
        detalhes.append(String.format("----------------------------------------------%n"));
        detalhes.append(String.format("%-23s: R$ %.2f%n", "Valor do imóvel", getValorImovel()));
        detalhes.append(String.format("%-23s: %s%n", "Zona", getZona()));

        // Detalhes sobre o financiamento
        detalhes.append(super.toString());

        return detalhes.toString();
    }
    //endregion

    //region Getters
    public Zonas getZona() {
        return zona;
    }
    //endregion
}