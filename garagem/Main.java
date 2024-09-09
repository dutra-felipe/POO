package garagem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(scanner);
        String opcao;

        do {
            estacionamento.processarVeiculo();
            System.out.println("Deseja informar outro veículo? (sim/não):");
            opcao = scanner.nextLine();
        } while (opcao.equalsIgnoreCase("sim"));

        System.out.println("Encerrando o sistema.");
        scanner.close();
    }
}
