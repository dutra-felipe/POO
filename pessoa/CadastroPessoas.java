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
            Pessoa[] new_pessoas = new Pessoa[pessoas.length + 1];
            System.arraycopy(pessoas, 0, new_pessoas, 0, pessoas.length);
            pessoas = new_pessoas;
            pessoas[qtd] = pess;
            qtd++;
            System.out.println("Cadastro cheio, aumentando o tamanho do array.");        
        }
    }

    public void imprimeCadastro() {
        for (int i = 0; i < qtd; i++) {
            pessoas[i].imprimeDados();
        }
    }
}
