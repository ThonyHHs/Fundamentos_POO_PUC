package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable{
    // Atributos
    private double valorImovel;
    private int prazoFinanciamentoAnos;
    private double taxaJurosAnual;

    // Construtor
    public Financiamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamentoAnos = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    
    //region Métodos
    public double calcularPagamentoMensal() {
        return (this.valorImovel / this.getPrazoFinanciamentoMeses()) * (1 + this.getTaxaJurosMensal());
    }

    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.getPrazoFinanciamentoMeses();
    }

    public void imprimirDados() {
        System.out.printf("Valor de pagamento mensal: R$ %.2f, valor do imóvel: R$ %.2f, valor do financiamento: R$ %.2f\n", calcularPagamentoMensal(), this.valorImovel, calcularTotalPagamento());
    }

    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        // Detalhes sobre o financiamento
        detalhes.append(String.format("%-23s: %d anos%n", "Prazo do financiamento",getPrazoFinanciamentoAnos()));
        detalhes.append(String.format("%-23s: %.2f%%%n", "Taxa de juros anual", getTaxaJurosAnual()*100));
        detalhes.append(String.format("%-23s: R$ %.2f%n", "Valor da mensalidade", calcularPagamentoMensal()));
        detalhes.append(String.format("%-23s: R$ %.2f%n", "Valor total", calcularTotalPagamento()));

        return detalhes.toString();
    }
    //endregion


    //region Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamentoAnos() {
        return prazoFinanciamentoAnos;
    }

    public int getPrazoFinanciamentoMeses() {
        return prazoFinanciamentoAnos * 12;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }
    
    public double getTaxaJurosMensal() {
        return taxaJurosAnual / 12;
    }
    //endregion
}
