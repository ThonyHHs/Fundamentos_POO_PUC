package modelo;

import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    // Atributos
    private double areaConstruida;
    private double areaTerreno;

    // Construtor
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    //region Métodos
    private void validarAcrescimo(double valorJuros, double valorAcrescimo) throws AcrescimoMaiorDoQueJurosException {
        if (valorAcrescimo > valorJuros) {
            throw new AcrescimoMaiorDoQueJurosException("Valor do Acrescimo é maior que os juros!");
        }
    }

    @Override
    public double calcularPagamentoMensal() {
        double valorJuros = getValorImovel() * getTaxaJurosMensal();
        double valorAcrescimo = 80;
        try {
            validarAcrescimo(valorJuros, valorAcrescimo);
        } catch (AcrescimoMaiorDoQueJurosException e) {
            valorAcrescimo = valorJuros;
        }

        return super.calcularPagamentoMensal() + valorAcrescimo;
    }

    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        // Detalhes sobre o imóvel
        detalhes.append(String.format("CASA%n"));
        detalhes.append(String.format("----------------------------------------------%n"));
        detalhes.append(String.format("%-23s: R$ %.2f%n", "Valor do imóvel", getValorImovel()));
        detalhes.append(String.format("%-23s: %.2f m^2%n", "Área terreno", this.areaTerreno));
        detalhes.append(String.format("%-23s: %.2f m^2%n", "Área construida", this.areaConstruida));

        // Detalhes sobre o financiamento
        detalhes.append(super.toString());

        return detalhes.toString();
    }
    //endregion
    
    //region Getters
    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }
    //endregion
}
