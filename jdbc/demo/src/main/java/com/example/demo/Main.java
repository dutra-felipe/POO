package com.example.demo;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.createTable();

        // Insert products
        Product p1 = new Product("Informática", "Notebook Dell XPS 13", 1.5, 10, Product.MeasurementUnit.KG);
        Product p2 = new Product("Limpeza", "Detergente Líquido", 0.5, 100, Product.MeasurementUnit.LITER);
        Product p3 = new Product("Casa & Decoração", "Tapete Sala", 2.0, 5, Product.MeasurementUnit.SQUARE_METER);
        Product p4 = new Product("Informática", "Mouse Wireless", 0.1, 50, Product.MeasurementUnit.KG);
        Product p5 = new Product("Casa & Decoração", "Cortina Blackout", 1.0, 15, Product.MeasurementUnit.METER);

        dao.insert(p1);
        dao.insert(p2);
        dao.insert(p3);
        dao.insert(p4);
        dao.insert(p5);

        // List all products
        System.out.println("\nAll products:");
        dao.findAll().forEach(System.out::println);

        // Update products
        p1.setQuantity(15);
        dao.update(p1);

        p3.setWeight(2.5);
        p3.setQuantity(8);
        dao.update(p3);

        // List all products
        System.out.println("\nChanged Products:");
        dao.findAll().forEach(System.out::println);

        // Delete product
        dao.delete(p4.getId());

        // List all products
        System.out.println("\n1 Product Deleted:");
        dao.findAll().forEach(System.out::println);

        // Show detailed info for specific products
        System.out.println("\nDetailed product information:");
        System.out.println(dao.findById(p1.getId()));
        System.out.println(dao.findById(p3.getId()));
    }
}
