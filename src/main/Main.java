package main;

import java.util.ArrayList;
import java.util.List;

import modelo.*;
import util.InterfaceUsuario;
import util.SalvaFinanciamento;
import util.Zonas;

public class Main {
    public static void main(String[] args) {
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        List<Financiamento> listaFinanciamentos = new ArrayList<Financiamento>();

        // input usuário
        double valorImovel = InterfaceUsuario.getValorImovel();
        int prazoFinanciamento = InterfaceUsuario.getPrazoFinancimento();
        double taxaJuros = InterfaceUsuario.getTaxa();


        // adiciona o financiamentos na lista
        listaFinanciamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros, 230, 600));
        listaFinanciamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros, 248, 480));
        listaFinanciamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, 1, 5));
        listaFinanciamentos.add(new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, 2, 10));
        listaFinanciamentos.add(new Terreno(valorImovel, prazoFinanciamento, taxaJuros, Zonas.RESIDENCIAL));

        // percorre a lista imprimindo as informações de cada financiamento
        for (int i = 0; i < listaFinanciamentos.size(); i++) {
            System.out.printf("Financiamento %d - ", i+1);
            listaFinanciamentos.get(i).imprimirDados();
            totalImoveis += listaFinanciamentos.get(i).getValorImovel();
            totalFinanciamentos += listaFinanciamentos.get(i).calcularTotalPagamento();
        }

        // salva as informações em um arquivo
        SalvaFinanciamento.salvaTexto(listaFinanciamentos, "financiamentos.txt");
        SalvaFinanciamento.serializaLista(listaFinanciamentos, "listaFinanciamento.data");

        // SalvaFinanciamento.leTexto("financiamentos.txt");
        // List<Financiamento> teste = SalvaFinanciamento.desserializaLista("listaFinanciamento.data");

        System.out.printf("Total de todos os imóveis: R$ %.2f, total de todos os financiamentos: R$ %.2f.\n", totalImoveis, totalFinanciamentos);
    }
}
