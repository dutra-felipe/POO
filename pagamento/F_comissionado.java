package pagamento;

public class F_comissionado extends Funcionario{
    private double comissão;

    public F_comissionado(String nome, String sobrenome, String cpf, double comissão){
        super(nome, sobrenome, cpf);

        if(comissão < 0){
            throw new IllegalArgumentException("Comissão tem que ser maior que 0");
        }

        this.comissão = comissão;
    }

    public void setSalario(double comissão){
        if(comissão < 0){
            throw new IllegalArgumentException("Comissão tem que ser maior que 0");
        }

        this.comissão = comissão;
    }

    public double getSalario(){
        return comissão;
    }

    @Override
    public double CalcularPagamento(){
        return getSalario();
    }

    @Override
    public String toString(){
        return String.format("%s%nComissão: $%,.2f", super.toString(), getSalario());
    }
}
