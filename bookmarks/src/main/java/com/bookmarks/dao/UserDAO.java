package com.bookmarks.dao;

import com.bookmarks.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void create(User user) throws SQLException {
        String sql = "INSERT INTO users (access_key, password, age, email_server) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getAccessKey());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getAge());
            stmt.setString(4, user.getEmailServer());
            
            stmt.executeUpdate();
        }
    }

    public User findByAccessKey(String accessKey) throws SQLException {
        String sql = "SELECT * FROM users WHERE access_key = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, accessKey);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setAccessKey(rs.getString("access_key"));
                    user.setPassword(rs.getString("password"));
                    user.setAge(rs.getInt("age"));
                    user.setEmailServer(rs.getString("email_server"));
                    return user;
                }
            }
        }
        return null;
    }

    public void update(User user) throws SQLException {
        String sql = "UPDATE users SET password = ?, age = ?, email_server = ? WHERE access_key = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getPassword());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getEmailServer());
            stmt.setString(4, user.getAccessKey());
            
            stmt.executeUpdate();
        }
    }

    public void delete(String accessKey) throws SQLException {
        String sql = "DELETE FROM users WHERE access_key = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, accessKey);
            stmt.executeUpdate();
        }
    }

    public List<User> listAll() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                User user = new User();
                user.setAccessKey(rs.getString("access_key"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setEmailServer(rs.getString("email_server"));
                users.add(user);
            }
        }
        return users;
    }
}
