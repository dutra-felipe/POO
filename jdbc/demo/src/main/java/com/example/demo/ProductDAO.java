package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS products (
                id SERIAL PRIMARY KEY,
                type VARCHAR(100) NOT NULL,
                description TEXT NOT NULL,
                weight DOUBLE PRECISION NOT NULL,
                quantity INTEGER NOT NULL,
                unit VARCHAR(20) NOT NULL
            )
        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating table", e);
        }
    }

    public void insert(Product product) {
        String sql = "INSERT INTO products (type, description, weight, quantity, unit) VALUES (?, ?, ?, ?, ?) RETURNING id";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, product.getType());
            pstmt.setString(2, product.getDescription());
            pstmt.setDouble(3, product.getWeight());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getUnit().toString());
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting product", e);
        }
    }

    public void update(Product product) {
        String sql = "UPDATE products SET type=?, description=?, weight=?, quantity=?, unit=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, product.getType());
            pstmt.setString(2, product.getDescription());
            pstmt.setDouble(3, product.getWeight());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getUnit().toString());
            pstmt.setLong(6, product.getId());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating product", e);
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM products WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting product", e);
        }
    }

    public Product findById(Long id) {
        String sql = "SELECT * FROM products WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Product product = new Product(
                    rs.getString("type"),
                    rs.getString("description"),
                    rs.getDouble("weight"),
                    rs.getInt("quantity"),
                    Product.MeasurementUnit.valueOf(rs.getString("unit"))
                );
                product.setId(rs.getLong("id"));
                return product;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding product", e);
        }
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Product product = new Product(
                    rs.getString("type"),
                    rs.getString("description"),
                    rs.getDouble("weight"),
                    rs.getInt("quantity"),
                    Product.MeasurementUnit.valueOf(rs.getString("unit"))
                );
                product.setId(rs.getLong("id"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error listing products", e);
        }
        return products;
    }
}
