package impostos;

public class Item {
    private String nome;
    private double preco;
    private boolean isProduto;

    public Item(String nome, double preco, boolean isProduto) {
        this.nome = nome;
        this.preco = preco;
        this.isProduto = isProduto;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isProduto() {
        return isProduto;
    }
}
