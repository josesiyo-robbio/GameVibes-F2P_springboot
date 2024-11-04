package com.josesiyo_robbio.GameVibes_F2P.request;

public class GameInfoRequest {
    private String title;
    private String shortDescription;
    private String genre;

    // Constructor, getters y setters
    public GameInfoRequest(String title, String shortDescription, String genre) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.genre = genre;
    }

    // getters y setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}