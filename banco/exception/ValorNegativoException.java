package banco.exception;

public class ValorNegativoException extends Exception{
    private double valor;
    
    public ValorNegativoException(String message, double valor){
        super(message);
        this.valor = valor;
        System.err.println("Valor Negativo Inserido");
    }

}
