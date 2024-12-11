package com.bookmarks.service;

import com.bookmarks.dao.UserDAO;
import com.bookmarks.model.User;
import java.sql.SQLException;

public class AuthenticationService {
    private final UserDAO userDAO;

    public AuthenticationService() {
        this.userDAO = new UserDAO();
    }

    public boolean authenticate(String accessKey, String password) {
        try {
            User user = userDAO.findByAccessKey(accessKey);
            return user != null && user.getPassword().equals(password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar usuário", e);
        }
    }
}
