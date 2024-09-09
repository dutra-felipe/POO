package garagem;

public class Motocicleta extends Veiculo {
    public Motocicleta(double peso) {
        super("Motocicleta", peso);
    }

    @Override
    public double calcularPreco() {
        if (getPeso() <= 100) {
            return 2.00;
        } else if (getPeso() <= 299.9) {
            return 4.00;
        } else {
            return 10.00;
        }
    }

    @Override
    public boolean podeEstacionar() {
        return getPeso() <= 400;
    }
}
