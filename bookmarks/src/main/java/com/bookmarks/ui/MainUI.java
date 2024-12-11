package com.bookmarks.ui;

import com.bookmarks.service.AuthenticationService;
import java.util.Scanner;

public class MainUI {
    private final Scanner scanner;
    private final AuthenticationService authService;
    private final UserUI userUI;
    private final SiteUI siteUI;
    private String loggedInUser;

    public MainUI() {
        this.scanner = new Scanner(System.in);
        this.authService = new AuthenticationService();
        this.userUI = new UserUI(scanner);
        this.siteUI = new SiteUI(scanner);
    }

    public void start() {
        while (true) {
            if (loggedInUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }

    private void showLoginMenu() {
        System.out.println("\n=== Sistema de Bookmarks ===");
        System.out.println("1. Login");
        System.out.println("2. Cadastrar novo usuário");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                doLogin();
                break;
            case 2:
                userUI.createUser();
                break;
            case 3:
                System.out.println("Até logo!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Gerenciar sites");
        System.out.println("2. Gerenciar perfil");
        System.out.println("3. Logout");
        System.out.print("Escolha uma opção: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                siteUI.showSiteMenu(loggedInUser);
                break;
            case 2:
                userUI.showUserMenu(loggedInUser);
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void doLogin() {
        System.out.print("Nome do Usuário: ");
        String accessKey = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        if (authService.authenticate(accessKey, password)) {
            loggedInUser = accessKey;
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Credenciais inválidas!");
        }
    }

    private void logout() {
        loggedInUser = null;
        System.out.println("Logout realizado com sucesso!");
    }

    public static void main(String[] args) {
        new MainUI().start();
    }
}
