package banco;

import banco.exception.SaldoInsuficienteException;
import banco.exception.ValorNegativoException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Conta_Bancaria conta = new Conta_Bancaria(0, 11111);
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        do { 
            try {
                System.out.println("Informe o valor a depositar: ");
                double valorDepositar = scanner.nextDouble();
                conta.depositar(valorDepositar);
                System.out.println("O saldo da conta após o depósito é " + conta.consultarSaldo());
            } catch (ValorNegativoException e) {
                System.out.println("O valor depositado não pode ser negativo.");
            } catch (Exception e){
                System.out.println("Ocorreu um erro");
            }

            try {
                System.out.println("Informe o valor a sacar: ");
                double valorSacar = scanner.nextDouble();
                conta.sacar(valorSacar);
                System.out.println("O saldo da conta após o saque é " + conta.consultarSaldo());
            } catch (SaldoInsuficienteException e) {
                System.out.println("O valor sacado não pode ser maior que o saldo");
            } catch (ValorNegativoException e) {
                System.out.println("O valor sacado não pode ser negativo");
            } catch (Exception e){
                System.out.println("Ocorreu um erro");
            }

            System.out.println("Deseja (e)ncerrar a execução? ");
            String opcao = scanner.next();
            continuar = !opcao.equalsIgnoreCase("e");
        } while (continuar);
        System.out.println("Isso fica feliz em ser útil. \nAté a próxima!");

    }
}
