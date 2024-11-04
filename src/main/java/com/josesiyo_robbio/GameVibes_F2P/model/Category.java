package com.josesiyo_robbio.GameVibes_F2P.model;



public class Category
{
    private String name;

    // Constructor
    public Category(String name)
    {
        this.name = name;
    }


    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}