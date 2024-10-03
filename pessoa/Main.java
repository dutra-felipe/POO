package pessoa;

public class Main {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas(10);

        Cliente cliente = new Cliente("Maria", new Data(10, 5, 1985), 123);
        cadastro.cadastraPessoa(cliente);

        Funcionario funcionario = new Funcionario("João", new Data(22, 8, 1990), 2500.0f);
        cadastro.cadastraPessoa(funcionario);

        Gerente gerente = new Gerente("Ana", new Data(15, 3, 1980), 5000.0f, "TI");
        cadastro.cadastraPessoa(gerente);

        cadastro.imprimeCadastro();
    }
}
