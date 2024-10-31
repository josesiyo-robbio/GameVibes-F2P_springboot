package com.josesiyo_robbio.GameVibes_F2P.dto;

public class RecommendationDTO {
    private String mood;
    private String hour;

    // Constructor
    public RecommendationDTO(String mood, String hour) {
        this.mood = mood;
        this.hour = hour;
    }

    // Getters y Setters
    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "RecommendationDTO{" +
                "mood='" + mood + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}