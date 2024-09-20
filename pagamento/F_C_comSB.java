package pagamento;

public class F_C_comSB extends Funcionario{
    private double comissao;
    private double salario;

    public F_C_comSB(String nome, String sobrenome, String cpf, double comissao, double salario){
        super(nome, sobrenome, cpf);

        if(comissao < 0){
            throw new IllegalArgumentException("Comissão tem que ser maior que 0");
        }

        if(salario < 0){
            throw new IllegalArgumentException("Salário tem que ser maior que 0");
        }

        this.comissao = comissao;
        this.salario = salario;

    }

    public void setSalario(double comissão, double salario){
        if(comissão < 0){
            throw new IllegalArgumentException("Comissão tem que ser maior que 0");
        }

        if(salario < 0){
            throw new IllegalArgumentException("Salário tem que ser maior que 0");
        }

        this.comissao = comissão;
        this.salario = salario + comissão;
    }

    public double getSalario(){
        return salario + comissao;
    }

    @Override
    public double CalcularPagamento(){
        return getSalario();
    }

    @Override
    public String toString(){
        return String.format("%s%nSalário: $%,.2f", super.toString(), getSalario());
    }
}
