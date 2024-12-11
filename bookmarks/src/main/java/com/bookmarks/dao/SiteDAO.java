package com.bookmarks.dao;

import com.bookmarks.model.Site;
import com.bookmarks.model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiteDAO {
    public void create(Site site) throws SQLException {
        String sql = "INSERT INTO sites (url, name, description, category, user_access_key) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, site.getUrl());
            stmt.setString(2, site.getName());
            stmt.setString(3, site.getDescription());
            stmt.setString(4, site.getCategory().name());
            stmt.setString(5, site.getUserAccessKey());
            
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    site.setId(generatedKeys.getLong(1));
                }
            }
        }
    }

    public Site findById(Long id) throws SQLException {
        String sql = "SELECT * FROM sites WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToSite(rs);
                }
            }
        }
        return null;
    }

    public List<Site> findByUser(String userAccessKey) throws SQLException {
        List<Site> sites = new ArrayList<>();
        String sql = "SELECT * FROM sites WHERE user_access_key = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, userAccessKey);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    sites.add(mapResultSetToSite(rs));
                }
            }
        }
        return sites;
    }

    public void update(Site site) throws SQLException {
        String sql = "UPDATE sites SET url = ?, name = ?, description = ?, category = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, site.getUrl());
            stmt.setString(2, site.getName());
            stmt.setString(3, site.getDescription());
            stmt.setString(4, site.getCategory().name());
            stmt.setLong(5, site.getId());
            
            stmt.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM sites WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Site mapResultSetToSite(ResultSet rs) throws SQLException {
        Site site = new Site();
        site.setId(rs.getLong("id"));
        site.setUrl(rs.getString("url"));
        site.setName(rs.getString("name"));
        site.setDescription(rs.getString("description"));
        site.setCategory(Category.valueOf(rs.getString("category")));
        site.setUserAccessKey(rs.getString("user_access_key"));
        return site;
    }
}
