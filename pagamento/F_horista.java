package pagamento;

public class F_horista extends Funcionario {
    private int horas;
    private double salarioPorHora = 20.0; 

    public F_horista(String nome, String sobrenome, String cpf, int horas) {
        super(nome, sobrenome, cpf);

        if (horas < 0) {
            throw new IllegalArgumentException("Horas tem que ser maior que 0");
        }

        this.horas = horas;
    }

    public void setHoras(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Horas tem que ser maior que 0");
        }
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    public double getSalario() {
        return horas * salarioPorHora;
    }

    @Override
    public double CalcularPagamento() {
        return getSalario();
    }

    @Override
    public String toString() {
        return String.format("%s%nHoras trabalhadas: %d%nSalário: $%,.2f", 
            super.toString(), getHoras(), getSalario());
    }
}
