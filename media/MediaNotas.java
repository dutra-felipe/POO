package media;

import java.util.Scanner;

public class MediaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double soma = 0;
        int quantidadeNotas = 4;

        for (int i = 1; i <= quantidadeNotas; i++) {
            System.out.print("Digite a nota " + i + ": ");
            double nota = scanner.nextDouble();
            soma += nota;
        }

        double media = soma / quantidadeNotas;

        System.out.println("A média das notas é: " + media);

        scanner.close();
    }
}
