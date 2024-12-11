package com.bookmarks.ui;

import com.bookmarks.model.Site;
import com.bookmarks.model.Category;
import com.bookmarks.service.SiteService;
import java.util.List;
import java.util.Scanner;

public class SiteUI {
    private final Scanner scanner;
    private final SiteService siteService;

    public SiteUI(Scanner scanner) {
        this.scanner = scanner;
        this.siteService = new SiteService();
    }

    public void showSiteMenu(String userAccessKey) {
        while (true) {
            System.out.println("\n=== Gerenciamento de Sites ===");
            System.out.println("1. Listar sites");
            System.out.println("2. Adicionar novo site");
            System.out.println("3. Editar site");
            System.out.println("4. Excluir site");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    listSites(userAccessKey);
                    break;
                case 2:
                    addSite(userAccessKey);
                    break;
                case 3:
                    editSite(userAccessKey);
                    break;
                case 4:
                    deleteSite(userAccessKey);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void listSites(String userAccessKey) {
        try {
            List<Site> sites = siteService.getSitesByUser(userAccessKey);
            if (sites.isEmpty()) {
                System.out.println("\nNenhum site cadastrado.");
                return;
            }

            System.out.println("\nSites cadastrados:");
            for (Site site : sites) {
                System.out.println("\nID: " + site.getId());
                System.out.println("Nome: " + site.getName());
                System.out.println("URL: " + site.getUrl());
                System.out.println("Descrição: " + site.getDescription());
                System.out.println("Categoria: " + site.getCategory().getDisplayName());
                System.out.println("-----------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar sites: " + e.getMessage());
        }
    }

    private void addSite(String userAccessKey) {
        try {
            System.out.println("\n=== Adicionar Novo Site ===");
            
            System.out.print("URL: ");
            String url = scanner.nextLine();
            
            System.out.print("Nome: ");
            String name = scanner.nextLine();
            
            System.out.print("Descrição: ");
            String description = scanner.nextLine();
            
            System.out.println("\nCategorias disponíveis:");
            for (Category category : Category.values()) {
                System.out.println(category.ordinal() + ". " + category.getDisplayName());
            }
            System.out.print("Escolha a categoria: ");
            int categoryIndex = Integer.parseInt(scanner.nextLine());
            Category category = Category.values()[categoryIndex];

            Site site = new Site(url, name, description, category, userAccessKey);
            siteService.createSite(site);
            
            System.out.println("Site adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar site: " + e.getMessage());
        }
    }

    private void editSite(String userAccessKey) {
        try {
            listSites(userAccessKey);
            
            System.out.print("\nDigite o ID do site que deseja editar: ");
            Long siteId = Long.parseLong(scanner.nextLine());
            
            Site site = siteService.getSite(siteId);
            if (site == null || !site.getUserAccessKey().equals(userAccessKey)) {
                System.out.println("Site não encontrado!");
                return;
            }

            System.out.print("Nova URL (enter para manter atual): ");
            String url = scanner.nextLine();
            if (!url.isEmpty()) {
                site.setUrl(url);
            }

            System.out.print("Novo nome (enter para manter atual): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                site.setName(name);
            }

            System.out.print("Nova descrição (enter para manter atual): ");
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                site.setDescription(description);
            }

            System.out.println("\nCategorias disponíveis:");
            for (Category category : Category.values()) {
                System.out.println(category.ordinal() + ". " + category.getDisplayName());
            }
            System.out.print("Nova categoria (enter para manter atual): ");
            String categoryStr = scanner.nextLine();
            if (!categoryStr.isEmpty()) {
                int categoryIndex = Integer.parseInt(categoryStr);
                site.setCategory(Category.values()[categoryIndex]);
            }

            siteService.updateSite(site);
            System.out.println("Site atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao editar site: " + e.getMessage());
        }
    }

    private void deleteSite(String userAccessKey) {
        try {
            listSites(userAccessKey);
            
            System.out.print("\nDigite o ID do site que deseja excluir: ");
            Long siteId = Long.parseLong(scanner.nextLine());
            
            Site site = siteService.getSite(siteId);
            if (site == null || !site.getUserAccessKey().equals(userAccessKey)) {
                System.out.println("Site não encontrado!");
                return;
            }

            System.out.print("Tem certeza que deseja excluir este site? (s/n): ");
            String confirm = scanner.nextLine();
            
            if (confirm.equalsIgnoreCase("s")) {
                siteService.deleteSite(siteId);
                System.out.println("Site excluído com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir site: " + e.getMessage());
        }
    }
}
