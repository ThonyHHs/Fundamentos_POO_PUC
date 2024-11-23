package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import modelo.Financiamento;

public class SalvaFinanciamento {
    public static void salvaTexto(List<Financiamento> lista, String nomeArquivo) {
        PrintWriter fileInput = null;
        try {
            fileInput = new PrintWriter(new FileWriter(nomeArquivo));

            for (int i=0; i < lista.size(); i++) {
                fileInput.println("==============================================");
                fileInput.printf("Financiamento %d - ", (i+1));
                fileInput.write(lista.get(i).toString());
                fileInput.println();
            }

            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leTexto(String nomeArquivo) {
        BufferedReader fileOutput = null;
        try {
            fileOutput = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = fileOutput.readLine()) != null) {
                System.out.println(linha);
            }
            fileOutput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void serializaLista(List<Financiamento> lista, String nomeArquivo) {
        ObjectOutputStream fileInput = null;
        try {
            fileInput = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            fileInput.writeObject(lista);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Financiamento> desserializaLista(String nomeArquivo) {
        ObjectInputStream fileOutput = null;
        List<Financiamento> lista = null;
        try {
            fileOutput = new ObjectInputStream(new FileInputStream(nomeArquivo));
            lista = (List<Financiamento>) fileOutput.readObject();
            fileOutput.close();
            return lista;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
