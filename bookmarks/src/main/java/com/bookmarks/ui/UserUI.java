package com.bookmarks.ui;

import com.bookmarks.model.User;
import com.bookmarks.service.UserService;
import java.util.Scanner;

public class UserUI {
    private final Scanner scanner;
    private final UserService userService;

    public UserUI(Scanner scanner) {
        this.scanner = scanner;
        this.userService = new UserService();
    }

    public void createUser() {
        try {
            System.out.println("\n=== Cadastro de Usuário ===");
            
            System.out.print("Chave de acesso (6 caracteres - letras minúsculas e números): ");
            String accessKey = scanner.nextLine();
            
            System.out.print("Senha: ");
            String password = scanner.nextLine();
            
            System.out.print("Idade: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Servidor de email: ");
            String emailServer = scanner.nextLine();

            User user = new User(accessKey, password, age, emailServer);
            userService.createUser(user);
            
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void showUserMenu(String accessKey) {
        while (true) {
            System.out.println("\n=== Gerenciamento de Perfil ===");
            System.out.println("1. Visualizar dados");
            System.out.println("2. Atualizar dados");
            System.out.println("3. Excluir conta");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    showUserData(accessKey);
                    break;
                case 2:
                    updateUser(accessKey);
                    break;
                case 3:
                    if (deleteUser(accessKey)) {
                        return;
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void showUserData(String accessKey) {
        try {
            User user = userService.getUser(accessKey);
            if (user != null) {
                System.out.println("\nDados do usuário:");
                System.out.println("Chave de acesso: " + user.getAccessKey());
                System.out.println("Idade: " + user.getAge());
                System.out.println("Servidor de email: " + user.getEmailServer());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar dados: " + e.getMessage());
        }
    }

    private void updateUser(String accessKey) {
        try {
            User user = userService.getUser(accessKey);
            if (user != null) {
                System.out.print("Nova senha (enter para manter atual): ");
                String password = scanner.nextLine();
                if (!password.isEmpty()) {
                    user.setPassword(password);
                }

                System.out.print("Nova idade (enter para manter atual): ");
                String ageStr = scanner.nextLine();
                if (!ageStr.isEmpty()) {
                    user.setAge(Integer.parseInt(ageStr));
                }

                System.out.print("Novo servidor de email (enter para manter atual): ");
                String emailServer = scanner.nextLine();
                if (!emailServer.isEmpty()) {
                    user.setEmailServer(emailServer);
                }

                userService.updateUser(user);
                System.out.println("Dados atualizados com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar dados: " + e.getMessage());
        }
    }

    private boolean deleteUser(String accessKey) {
        System.out.print("Tem certeza que deseja excluir sua conta? (s/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("s")) {
            try {
                userService.deleteUser(accessKey);
                System.out.println("Conta excluída com sucesso!");
                return true;
            } catch (Exception e) {
                System.out.println("Erro ao excluir conta: " + e.getMessage());
            }
        }
        return false;
    }
}

