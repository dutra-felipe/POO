package banco;

import banco.exception.SaldoInsuficienteException;
import banco.exception.ValorNegativoException;

public class Conta_Bancaria {
    private double saldo;
    private int numero;

    public Conta_Bancaria(double saldo, int numero) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public double consultarSaldo(){
        return saldo;
    }

    public void depositar(double valor_depositado) throws ValorNegativoException{
        if(valor_depositado < 0){
            throw new ValorNegativoException("Não é possível depositar valores menores que zero", valor_depositado);
        }

        this.saldo += valor_depositado;
    }

    public void transferir(double valor_transferido, Conta_Bancaria contaDestino) throws ValorNegativoException, SaldoInsuficienteException{
        if(valor_transferido > this.saldo){
            throw new SaldoInsuficienteException("Não é possível transferir um valor maior que seu saldo.", this.saldo, valor_transferido);
        }
        
        this.saldo -= valor_transferido;
        contaDestino.depositar(valor_transferido);
    }

    public void sacar(double valor_sacado)throws ValorNegativoException, SaldoInsuficienteException{
        if(valor_sacado < 0){
            throw new ValorNegativoException("Não é possível sacar valores menores que zero", valor_sacado);
        }

        if(valor_sacado > this.saldo){
            throw new SaldoInsuficienteException("Não é possível sacar um valor maior que seu saldo.", this.saldo, valor_sacado);
        }
        
        this.saldo -= valor_sacado;
    }
}
