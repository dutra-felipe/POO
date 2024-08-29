package impostos;

public class IPI implements Imposto {
    private static final double ALIQUOTA = 0.219;

    @Override
    public double calcular(Item item) {
        if (item.isProduto()) {
            return item.getPreco() * ALIQUOTA;
        }
        return 0;
    }
}
