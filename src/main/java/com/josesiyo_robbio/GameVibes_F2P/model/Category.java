package com.josesiyo_robbio.GameVibes_F2P.model;

public class Category {
    private String name; // Nombre de la categoría

    // Constructor
    public Category(String name) {
        this.name = name;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}