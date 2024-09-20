package pagamento;

public abstract class Funcionario {
    private final String nome;
    private final String sobrenome;
    private final String cpf;

    public Funcionario(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String GetNome(){
        return nome;
    }
    public String GetSobrenome(){
        return sobrenome;
    }
    public String GetCpf(){
        return cpf;
    }

    @Override
    public String toString(){
        return String.format("%s %s%nCPF: %s", GetNome(), GetSobrenome(), GetCpf());
    }

    public abstract double CalcularPagamento();
}
