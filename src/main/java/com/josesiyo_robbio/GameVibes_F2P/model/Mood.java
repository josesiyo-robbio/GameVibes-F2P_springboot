package com.josesiyo_robbio.GameVibes_F2P.model;

import java.util.List;

public class Mood {
    private String name;
    private List<String> categories;

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
