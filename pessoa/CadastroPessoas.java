package pessoa;

public class CadastroPessoas {
    Pessoa[] pessoas;
    int qtd;

    public CadastroPessoas(int tamanho) {
        pessoas = new Pessoa[tamanho];
        qtd = 0;
    }

    public void cadastraPessoa(Pessoa pess) {
        if (qtd < pessoas.length) {
            pessoas[qtd] = pess;
            qtd++;
        } else {
            System.out.println("Cadastro cheio");
        }
    }

    public void imprimeCadastro() {
        for (int i = 0; i < qtd; i++) {
            pessoas[i].imprimeDados();
        }
    }
}
