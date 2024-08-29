package impostos;

public class ICMS implements Imposto {
    private static final double ALIQUOTA = 0.132;

    @Override
    public double calcular(Item item) {
        return item.getPreco() * ALIQUOTA;
    }
}
