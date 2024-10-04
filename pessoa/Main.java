package pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas(10);
        PessoaService pessoaService = new PessoaService(cadastro);
        Scanner scanner = new Scanner(System.in);

        try {
            //Hard-coded Cliente
            Cliente clienteHardCode = new Cliente("Kelwin", new Data(10, 10, 1990), 1234);
            pessoaService.cadastraPessoa(clienteHardCode);
            System.out.println("Cliente Hardcoded cadastrado com sucesso!");
            //Hard-coded Cliente2
            Cliente clienteHardCode2 = new Cliente("Pedro", new Data(11, 11, 1999), 1034);
            pessoaService.cadastraPessoa(clienteHardCode2);
            System.out.println("Cliente2 Hardcoded cadastrado com sucesso!");
            //Hard-coded Cliente3
            Cliente clienteHardCode3 = new Cliente("Gabriel", new Data(19, 9, 1998), 1200);
            pessoaService.cadastraPessoa(clienteHardCode3);
            System.out.println("Cliente3 Hardcoded cadastrado com sucesso!");

            // Cliente
            System.out.println("Digite o nome do Cliente:");
            String nomeCliente = scanner.nextLine();
            System.out.println("Digite o código do Cliente:");
            int codigoCliente = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Digite a data de nascimento do Cliente (dd/MM/yyyy):");
            String dataNascimentoCliente = scanner.nextLine();
            String[] dataCliente = dataNascimentoCliente.split("/"); 
            int diaCliente = Integer.parseInt(dataCliente[0]);
            int mesCliente = Integer.parseInt(dataCliente[1]);
            int anoCliente = Integer.parseInt(dataCliente[2]);
            Cliente cliente = new Cliente(nomeCliente, new Data(diaCliente, mesCliente, anoCliente), codigoCliente);
            pessoaService.cadastraPessoa(cliente);

            // Cliente VIP
            System.out.println("Digite o nome do Cliente VIP:");
            String nomeClienteVip = scanner.nextLine();
            System.out.println("Digite o código do Cliente VIP:");
            int codigoClienteVip = scanner.nextInt();
            System.out.println("Digite o percentual de desconto do Cliente VIP:");
            float descontoClienteVip = scanner.nextFloat();
            scanner.nextLine(); 
            System.out.println("Digite a data de nascimento do Cliente VIP (dd/MM/yyyy):");
            String dataNascimentoClienteVip = scanner.nextLine();
            String[] dataClienteVip = dataNascimentoClienteVip.split("/");
            int diaClienteVip = Integer.parseInt(dataClienteVip[0]);
            int mesClienteVip = Integer.parseInt(dataClienteVip[1]);
            int anoClienteVip = Integer.parseInt(dataClienteVip[2]);
            ClienteVip clienteVip = new ClienteVip(nomeClienteVip, new Data(diaClienteVip, mesClienteVip, anoClienteVip), codigoClienteVip, descontoClienteVip);
            pessoaService.cadastraPessoa(clienteVip);

            // Funcionário
            System.out.println("Digite o nome do Funcionário:");
            String nomeFuncionario = scanner.nextLine();
            System.out.println("Digite o salário do Funcionário:");
            float salarioFuncionario = scanner.nextFloat();
            scanner.nextLine(); 
            System.out.println("Digite a data de nascimento do Funcionário (dd/MM/yyyy):");
            String dataNascimentoFuncionario = scanner.nextLine();
            String[] dataFuncionario = dataNascimentoFuncionario.split("/");
            int diaFuncionario = Integer.parseInt(dataFuncionario[0]);
            int mesFuncionario = Integer.parseInt(dataFuncionario[1]);
            int anoFuncionario = Integer.parseInt(dataFuncionario[2]);
            Funcionario funcionario = new Funcionario(nomeFuncionario, new Data(diaFuncionario, mesFuncionario, anoFuncionario), salarioFuncionario);
            pessoaService.cadastraPessoa(funcionario);

            // Gerente
            System.out.println("Digite o nome do Gerente:");
            String nomeGerente = scanner.nextLine();
            System.out.println("Digite o salário do Gerente:");
            float salarioGerente = scanner.nextFloat();
            scanner.nextLine(); 
            System.out.println("Digite a área do Gerente:");
            String areaGerente = scanner.nextLine();
            System.out.println("Digite a data de nascimento do Gerente (dd/MM/yyyy):");
            String dataNascimentoGerente = scanner.nextLine();
            String[] dataGerente = dataNascimentoGerente.split("/");
            int diaGerente = Integer.parseInt(dataGerente[0]);
            int mesGerente = Integer.parseInt(dataGerente[1]);
            int anoGerente = Integer.parseInt(dataGerente[2]);
            Gerente gerente = new Gerente(nomeGerente, new Data(diaGerente, mesGerente, anoGerente), salarioGerente, areaGerente);
            pessoaService.cadastraPessoa(gerente);

        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        pessoaService.imprimeCadastro();
    }
}
