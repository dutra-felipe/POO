package impostos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do item:");
        String nome = scanner.nextLine();

        System.out.println("Informe o preço do item:");
        double preco = scanner.nextDouble();

        System.out.println("O item é um produto? (sim/não):");
        String tipo = scanner.next();

        boolean isProduto = tipo.equalsIgnoreCase("sim");

        Item item = new Item(nome, preco, isProduto);
        OperacaoComercial operacao = new OperacaoComercial(item);

        System.out.println("\nDetalhes da Operação Comercial:");
        operacao.imprimirDetalhes();

        scanner.close();
    }
}
