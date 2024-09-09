package garagem;

public class Furgao extends Veiculo {
    private boolean carregado;

    public Furgao(double peso, String tipoCarga) {
        super("Furgão", peso);
        this.carregado = tipoCarga.equalsIgnoreCase("Carregado");
    }

    @Override
    public double calcularPreco() {
        if (getPeso() <= 3 && !carregado) {
            return 25.00;
        } else if (getPeso() > 3 && getPeso() <= 6 && carregado) {
            return 50.00;
        } else {
            throw new IllegalArgumentException("Furgão não permitido.");
        }
    }

    @Override
    public boolean podeEstacionar() {
        return getPeso() <= 6;
    }
}
