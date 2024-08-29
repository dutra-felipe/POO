package impostos;

public class OperacaoComercial {
    private Item item;
    private double valorISS;
    private double valorICMS;
    private double valorIPI;
    private double valorTotal;

    public OperacaoComercial(Item item) {
        this.item = item;
        calcularValores();
    }

    private void calcularValores() {
        ISS iss = new ISS();
        ICMS icms = new ICMS();
        IPI ipi = new IPI();

        valorISS = iss.calcular(item);
        valorICMS = icms.calcular(item);
        valorIPI = ipi.calcular(item);
        valorTotal = item.getPreco() + valorISS + valorICMS + valorIPI;
    }

    public void imprimirDetalhes() {
        System.out.println("Item: " + item.getNome());
        System.out.println("Preço original: R$ " + item.getPreco());
        System.out.println("ISS (7.3%): R$ " + valorISS);
        System.out.println("ICMS (13.2%): R$ " + valorICMS);
        System.out.println("IPI (21.9%): R$ " + valorIPI);
        System.out.println("Valor total: R$ " + valorTotal);
    }
}
