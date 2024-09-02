package combustiveis;

import java.util.Scanner;

public class Abastecimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bomba bomba = new Bomba("Gasolina", 5.99, 1000.0);

        int opcao;
        do {
            System.out.println("\n1. Abastecer por valor");
            System.out.println("2. Abastecer por litro");
            System.out.println("3. Alterar valor do litro");
            System.out.println("4. Alterar tipo de combustível");
            System.out.println("5. Alterar quantidade de combustível");
            System.out.println("6. Mostrar total abastecido");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor para abastecer: R$ ");
                    double valor = scanner.nextDouble();
                    bomba.abastecerPorValor(valor);
                    break;
                case 2:
                    System.out.print("Informe a quantidade de litros para abastecer: ");
                    double litros = scanner.nextDouble();
                    bomba.abastecerPorLitro(litros);
                    break;
                case 3:
                    System.out.print("Informe o novo valor do litro: R$ ");
                    double novoValor = scanner.nextDouble();
                    bomba.alterarValor(novoValor);
                    break;
                case 4:
                    System.out.print("Informe o novo tipo de combustível: ");
                    scanner.nextLine();
                    String novoTipo = scanner.nextLine();
                    bomba.alterarCombustivel(novoTipo);
                    break;
                case 5:
                    System.out.print("Informe a nova quantidade de combustível na bomba: ");
                    double novaQuantidade = scanner.nextDouble();
                    bomba.alterarQuantidadeCombustivel(novaQuantidade);
                    break;
                case 6:
                    System.out.printf("Valor total abastecido: R$ %.2f\n", bomba.getValorTotalAbastecido());
                    System.out.printf("Quantidade de combustível restante: %.2f litros\n", bomba.getQuantidadeCombustivel());
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 7);

        scanner.close();
    }
}