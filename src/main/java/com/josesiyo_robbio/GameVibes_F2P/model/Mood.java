package com.josesiyo_robbio.GameVibes_F2P.model;

import java.util.List;



public class Mood
{
    private String name;
    private List<String> categories;


    // Getters and Setters
    public String getName()             { return name;          }
    public List<String> getCategories() { return categories;    }

    public void setName(String name)                    { this.name = name;                 }
    public void setCategories(List<String> categories)  { this.categories = categories;     }
}
