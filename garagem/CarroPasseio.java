package garagem;

public class CarroPasseio extends Veiculo {
    private String modelo;

    public CarroPasseio(double peso, String modelo) {
        super("Carro de Passeio", peso);
        this.modelo = modelo;
    }

    @Override
    public double calcularPreco() {
        if (getPeso() > 2) {
            return new Furgao(getPeso(), "Carro").calcularPreco();
        }

        switch (modelo.toLowerCase()) {
            case "hatchback":
                return 13.00;
            case "sedan":
                return 15.00;
            case "suv":
                return 20.00;
            default:
                throw new IllegalArgumentException("Modelo de carro desconhecido.");
        }
    }

    @Override
    public boolean podeEstacionar() {
        return getPeso() <= 2;
    }
}
