package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    // Atributos
    private static Scanner input = new Scanner(System.in);

    //region Métodos
    public static double getValorImovel() {
        return getDoubleInput("Digite o valor do imovel: R$ ");
    }

    public static int getPrazoFinancimento() {
        int prazo;
        do {
            prazo = getIntInput("Digite o prazo de financiamento (em anos): ");
            if (prazo > 50) {
                System.out.println("Valor inválido! O prazo máximo permitido é de 50 anos.");
            }
        } while (prazo > 50);
        return prazo;
    }
    
    public static double getTaxa() {
        double taxa;
        do {
            taxa = getDoubleInput("Digite a taxa de juros anual (%): ");
            if (taxa > 12) {
                System.out.println("Valor inválido! A taxa máxima permitida é de 12%.");
            }
        } while (taxa > 12);
        return taxa / 100;
    }
    //endregion

    //region Verificações de entrada
    private static double getDoubleInput(String inputMsg) {
        double valor = -1;
        do {
            try {
                System.out.print(inputMsg);
                valor = input.nextDouble();
                if (valor < 0) {
                    System.out.println("Valor inválido! insira um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira um número decimal!");
                input.next();
            }
        } while (valor < 0);
        return valor;
    }
    
    private static int getIntInput(String inputMsg) {
        int valor = -1;
        do {
            try {
                System.out.print(inputMsg);
                valor = input.nextInt();
                if (valor < 0) {
                    System.out.println("Valor inválido! insira um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira um número inteiro!");
                input.next();
            }
        } while (valor < 0);
        return valor;
    }
    //endregion
}
