package combustiveis;


public class Bomba {
    private String tipoCombustivel;
    private double valorLitro;
    private double quantidadeCombustivel;
    private double valorTotalAbastecido;

    public Bomba(String tipoCombustivel, double valorLitro, double quantidadeCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
        this.valorLitro = valorLitro;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.valorTotalAbastecido = 0;
    }

    public void abastecerPorValor(double valor) {
        double litros = valor / valorLitro;
        if (litros <= quantidadeCombustivel) {
            quantidadeCombustivel -= litros;
            valorTotalAbastecido += valor;
            System.out.printf("Abastecido %.2f litros.\n", litros);
        } else {
            System.out.println("Quantidade de combustível insuficiente na bomba.");
        }
    }

    public void abastecerPorLitro(double litros) {
        double valor = litros * valorLitro;
        if (litros <= quantidadeCombustivel) {
            quantidadeCombustivel -= litros;
            valorTotalAbastecido += valor;
            System.out.printf("Valor a ser pago: R$ %.2f\n", valor);
        } else {
            System.out.println("Quantidade de combustível insuficiente na bomba.");
        }
    }

    public void alterarValor(double novoValorLitro) {
        valorLitro = novoValorLitro;
        System.out.printf("Valor por litro alterado para: R$ %.2f\n", valorLitro);
    }

    public void alterarCombustivel(String novoTipoCombustivel) {
        tipoCombustivel = novoTipoCombustivel;
        System.out.println("Tipo de combustível alterado para: " + tipoCombustivel);
    }

    public void alterarQuantidadeCombustivel(double novaQuantidade) {
        quantidadeCombustivel = novaQuantidade;
        System.out.printf("Quantidade de combustível na bomba alterada para: %.2f litros\n", quantidadeCombustivel);
    }

    public double getValorTotalAbastecido() {
        return valorTotalAbastecido;
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }
}
