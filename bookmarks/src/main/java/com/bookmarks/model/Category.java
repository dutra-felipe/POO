package com.bookmarks.model;

public enum Category {
    EDUCATION("Educação"),
    ENTERTAINMENT("Entretenimento"),
    NEWS("Notícias"),
    TECHNOLOGY("Tecnologia"),
    SOCIAL_MEDIA("Redes Sociais");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
