package garagem;

public class Caminhonete extends Veiculo {
    private boolean carregada;

    public Caminhonete(double peso, boolean carregada) {
        super("Caminhonete", peso);
        this.carregada = carregada;
    }

    @Override
    public double calcularPreco() {
        if (getPeso() <= 3 && !carregada) {
            return 25.00;
        } else if (getPeso() > 3 && getPeso() <= 6 && carregada) {
            return 50.00;
        } else {
            throw new IllegalArgumentException("Caminhonete não permitida.");
        }
    }

    @Override
    public boolean podeEstacionar() {
        return getPeso() <= 6;
    }
}
