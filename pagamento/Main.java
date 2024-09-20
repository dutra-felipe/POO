package pagamento;

import pagamento.Funcionario;
import pagamento.F_assalariado;
import pagamento.F_horista;
import pagamento.F_comissionado;
import pagamento.F_C_comSB;

public class Main {
    public static void main(String[] args) {
        F_assalariado funcionario_assalariado = new F_assalariado("Jhon", "Green", "009.987.654-34", 800.00);

        F_horista funcionario_horista = new F_horista("Marcelo", "Black", "155.987.654-34", 20);

        F_comissionado funcionario_comissionado = new F_comissionado("Luiz", "Blue", "261.555.654-34", 200.00);

        F_C_comSB funcionario_comissionado_com_salario = new F_C_comSB("Dida", "Purple", "789.465.654-34", 200.00, 800.00);
        
        System.out.println(funcionario_assalariado);
        System.out.println("Pagamento: " + funcionario_assalariado.CalcularPagamento());
        System.out.println();

        System.out.println(funcionario_horista);
        System.out.println("Pagamento: " + funcionario_horista.CalcularPagamento());
        System.out.println();

        System.out.println(funcionario_comissionado);
        System.out.println("Pagamento: " + funcionario_comissionado.CalcularPagamento());
        System.out.println();

        System.out.println(funcionario_comissionado_com_salario);
        System.out.println("Pagamento: " + funcionario_comissionado_com_salario.CalcularPagamento());
        System.out.println();
    }
}
