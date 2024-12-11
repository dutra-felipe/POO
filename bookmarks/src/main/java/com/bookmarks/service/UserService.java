package com.bookmarks.service;

import com.bookmarks.dao.UserDAO;
import com.bookmarks.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void createUser(User user) {
        try {
            if (userDAO.findByAccessKey(user.getAccessKey()) != null) {
                throw new IllegalArgumentException("Usuário já existe");
            }
            userDAO.create(user);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar usuário", e);
        }
    }

    public User getUser(String accessKey) {
        try {
            return userDAO.findByAccessKey(accessKey);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário", e);
        }
    }

    public void updateUser(User user) {
        try {
            userDAO.update(user);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário", e);
        }
    }

    public void deleteUser(String accessKey) {
        try {
            userDAO.delete(accessKey);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar usuário", e);
        }
    }

    public List<User> listAllUsers() {
        try {
            return userDAO.listAll();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários", e);
        }
    }
}
