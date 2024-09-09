package garagem;

import java.util.Scanner;

public class Estacionamento {

    private Scanner scanner;

    public Estacionamento(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processarVeiculo() {
        System.out.println("Informe o tipo de veículo (Motocicleta, CarroPasseio, Caminhonete, Furgão):");
        String tipo = scanner.nextLine();

        System.out.println("Informe o peso do veículo (em toneladas):");
        double peso = scanner.nextDouble();

        Veiculo veiculo = null;
        scanner.nextLine();

        switch (tipo.toLowerCase()) {
            case "motocicleta":
                veiculo = new Motocicleta(peso);
                break;
            case "carropasseio":
                System.out.println("Informe o modelo do carro (hatchback, sedan, suv):");
                String modelo = scanner.nextLine();
                veiculo = new CarroPasseio(peso, modelo);
                break;
            case "caminhonete":
                System.out.println("A caminhonete está carregada? (sim/não):");
                String carregada = scanner.nextLine();
                veiculo = new Caminhonete(peso, carregada.equalsIgnoreCase("sim"));
                break;
            case "furgão":
                System.out.println("O furgão está carregado? (sim/não):");
                String tipoCarga = scanner.nextLine();
                veiculo = new Furgao(peso, tipoCarga.equalsIgnoreCase("sim") ? "Carregado" : "Não Carregado");
                break;
            default:
                System.out.println("Tipo de veículo inválido.");
                return;
        }

        if (veiculo.podeEstacionar()) {
            System.out.println("O valor cobrado por hora é: R$ " + veiculo.calcularPreco());
        } else {
            System.out.println("Este veículo não pode estacionar.");
        }
    }
}
