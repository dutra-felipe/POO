package pagamento;


public class F_assalariado extends Funcionario{
   private double salario;

   public F_assalariado(String nome, String sobrenome, String cpf, double salario){
        super(nome, sobrenome, cpf);

        if(salario < 0){
            throw new IllegalArgumentException("Salário tem que ser maior que 0");
        }

        this.salario = salario;
    }

   public void setSalario(double salario){
        if(salario < 0){
            throw new IllegalArgumentException("Salário tem que ser maior que 0");
        }

        this.salario = salario;
    }

    public double getSalario(){
        return salario;
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
