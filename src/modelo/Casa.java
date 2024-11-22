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
    
    //region Getters
    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }
    //endregion
}
