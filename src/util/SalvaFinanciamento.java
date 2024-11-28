package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Financiamento;

public class SalvaFinanciamento {
    public static void salvaTexto(List<Financiamento> lista, String nomeArquivo) {
        try (PrintWriter fileInput = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (int i=0; i < lista.size(); i++) {
                fileInput.println("==============================================");
                fileInput.printf("Financiamento %d - ", (i+1));
                fileInput.write(lista.get(i).toString());
                fileInput.println();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void leTexto(String nomeArquivo) {
        try (BufferedReader fileOutput = new BufferedReader(new FileReader(nomeArquivo));) {
            String linha;
            while ((linha = fileOutput.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void serializaLista(List<Financiamento> lista, String nomeArquivo) {
        try (ObjectOutputStream fileInput = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            fileInput.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Erro ao serializar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Financiamento> desserializaLista(String nomeArquivo) {
        try (ObjectInputStream fileOutput = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (List<Financiamento>) fileOutput.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao desserializar: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
