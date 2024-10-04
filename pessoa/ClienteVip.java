package pessoa;

public class ClienteVip extends Cliente {
    private float percentualDesconto;

    public ClienteVip(String nome, Data nascimento, int codigo, float percentualDesconto) {
        super(nome, nascimento, codigo);
        this.percentualDesconto = percentualDesconto;
    }

    public float getPercentualDesconto() {
        return percentualDesconto;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Cliente VIP: " + nome + ", Código: " + codigo + ", Desconto: " + percentualDesconto + "%, Nascimento: " + nascimento);
    }
}
