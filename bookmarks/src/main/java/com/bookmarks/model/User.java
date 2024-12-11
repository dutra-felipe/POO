package com.bookmarks.model;

public class User {
    private String accessKey;
    private String password;
    private int age;
    private String emailServer;

    public User() {}

    public User(String accessKey, String password, int age, String emailServer) {
        setAccessKey(accessKey);
        setPassword(password);
        setAge(age);
        setEmailServer(emailServer);
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        if (accessKey == null || !accessKey.matches("^[a-z0-9]{6}$")) {
            throw new IllegalArgumentException("Chave de acesso deve ter exatamente 6 caracteres (letras minúsculas e números)");
        }
        this.accessKey = accessKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia");
        }
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa");
        }
        this.age = age;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        if (emailServer == null || emailServer.trim().isEmpty()) {
            throw new IllegalArgumentException("Servidor de email não pode ser vazio");
        }
        this.emailServer = emailServer;
    }
}
