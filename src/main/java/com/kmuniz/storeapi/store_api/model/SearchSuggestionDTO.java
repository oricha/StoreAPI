package com.kmuniz.storeapi.store_api.model;

public class SearchSuggestionDTO {
    private Long id;
    private String name;
    private String type; // "MAKE", "MODEL", "VERSION"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
} 