package com.bookmarks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/bookmarksdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            initDatabase();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL não encontrado", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void initDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            // Criação da tabela de usuários
            stmt.execute("CREATE TABLE IF NOT EXISTS users ("
                + "access_key VARCHAR(6) PRIMARY KEY,"
                + "password VARCHAR(255) NOT NULL,"
                + "age INT NOT NULL,"
                + "email_server VARCHAR(255) NOT NULL"
                + ")");

            // Criação da tabela de sites
            stmt.execute("CREATE TABLE IF NOT EXISTS sites ("
                + "id SERIAL PRIMARY KEY,"
                + "url VARCHAR(255) NOT NULL,"
                + "name VARCHAR(255) NOT NULL,"
                + "description TEXT,"
                + "category VARCHAR(50) NOT NULL,"
                + "user_access_key VARCHAR(6) NOT NULL,"
                + "FOREIGN KEY (user_access_key) REFERENCES users(access_key)"
                + ")");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar banco de dados", e);
        }
    }
}
