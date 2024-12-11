package com.bookmarks.model;

public class Site {
    private Long id;
    private String url;
    private String name;
    private String description;
    private Category category;
    private String userAccessKey;

    public Site() {}

    public Site(String url, String name, String description, Category category, String userAccessKey) {
        setUrl(url);
        setName(name);
        setDescription(description);
        setCategory(category);
        setUserAccessKey(userAccessKey);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("URL não pode ser vazia");
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("URL deve começar com http:// ou https://");
        }
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula");
        }
        this.category = category;
    }

    public String getUserAccessKey() {
        return userAccessKey;
    }

    public void setUserAccessKey(String userAccessKey) {
        if (userAccessKey == null || userAccessKey.trim().isEmpty()) {
            throw new IllegalArgumentException("Chave de acesso do usuário não pode ser vazia");
        }
        this.userAccessKey = userAccessKey;
    }
}
