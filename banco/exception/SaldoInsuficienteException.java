package banco.exception;

public class SaldoInsuficienteException extends Exception {
    private double saldo;
    private double valor;
    
    public SaldoInsuficienteException(String message, double saldo, double valor){
        super(message);
        this.saldo = saldo;
        this.valor = valor;
        System.err.println("Saldo Insuficiente para Operação");
    }

}
