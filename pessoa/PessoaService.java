package pessoa;

public class PessoaService {
    private CadastroPessoas cadastro;
    private int maxFuncionarios = 7;
    private int maxGerentes = 1;
    private int totalFuncionarios = 0;
    private int totalGerentes = 0;

    public PessoaService(CadastroPessoas cadastro) {
        this.cadastro = cadastro;
    }

    public void cadastraPessoa(Pessoa pessoa) throws QuantidadeExcedidaException {
        if (pessoa instanceof Funcionario && !(pessoa instanceof Gerente)) {
            if (totalFuncionarios >= maxFuncionarios) {
                throw new QuantidadeExcedidaException("Quantidade máxima de funcionários excedida.");
            }
            totalFuncionarios++;
        } else if (pessoa instanceof Gerente) {
            if (totalGerentes >= maxGerentes) {
                throw new QuantidadeExcedidaException("Quantidade máxima de gerentes excedida.");
            }
            totalGerentes++;
        }
        cadastro.cadastraPessoa(pessoa);
    }

    public void imprimeCadastro() {
        cadastro.imprimeCadastro();
    }
}
