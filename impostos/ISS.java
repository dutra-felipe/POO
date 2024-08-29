package impostos;

public class ISS implements Imposto {
    private static final double ALIQUOTA = 0.073;

    @Override
    public double calcular(Item item) {
        if (!item.isProduto()) {
            return item.getPreco() * ALIQUOTA;
        }
        return 0;
    }
}
