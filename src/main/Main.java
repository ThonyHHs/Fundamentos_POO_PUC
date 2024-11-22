package main;

import java.util.List;
import java.util.ArrayList;
import util.InterfaceUsuario;
import modelo.*;

public class Main {
    public static void main(String[] args) {
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        List<Financiamento> listaFinanciamentos = new ArrayList<Financiamento>();

        // input usuário
        double valorImovel = InterfaceUsuario.getValorImovel();
        int prazoFinanciamento = InterfaceUsuario.getPrazoFinancimento();
        double taxaJuros = InterfaceUsuario.getTaxa();

        // adiciona o financiamento na lista
        listaFinanciamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros, 100, 120));
        listaFinanciamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros, 100, 120));
        listaFinanciamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, 2, 5));
        listaFinanciamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, 2, 5));
        listaFinanciamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJuros, "residencial"));

        // percorre a lista imprimindo as informações de cada financiamento
        for (int i = 0; i < listaFinanciamentos.size(); i++) {
            System.out.printf("Financiamento %d - ", i+1);
            listaFinanciamentos.get(i).imprimirDados();
            totalImoveis += listaFinanciamentos.get(i).getValorImovel();
            totalFinanciamentos += listaFinanciamentos.get(i).calcularTotalPagamento();
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f.\n", totalImoveis, totalFinanciamentos);
    }
}
