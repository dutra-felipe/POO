import java.util.Scanner;

class Item {
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

interface Imposto {
    double calcular(Item item);
}

class ISS implements Imposto {
    private static final double ALIQUOTA = 0.073;

    @Override
    public double calcular(Item item) {
        if (!item.isProduto()) {
            return item.getPreco() * ALIQUOTA;
        }
        return 0;
    }
}

class ICMS implements Imposto {
    private static final double ALIQUOTA = 0.132;

    @Override
    public double calcular(Item item) {
        return item.getPreco() * ALIQUOTA;
    }
}

class IPI implements Imposto {
    private static final double ALIQUOTA = 0.219;

    @Override
    public double calcular(Item item) {
        if (item.isProduto()) {
            return item.getPreco() * ALIQUOTA;
        }
        return 0;
    }
}

class OperacaoComercial {
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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do item:");
        String nome = scanner.nextLine();

        System.out.println("Informe o preço do item:");
        double preco = scanner.nextDouble();

        System.out.println("O item é um produto? (sim/não):");
        String tipo = scanner.next();

        boolean isProduto = tipo.equalsIgnoreCase("sim");

        Item item = new Item(nome, preco, isProduto);
        OperacaoComercial operacao = new OperacaoComercial(item);

        System.out.println("\nDetalhes da Operação Comercial:");
        operacao.imprimirDetalhes();

        scanner.close();
    }
}
