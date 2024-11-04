package com.josesiyo_robbio.GameVibes_F2P.request;



public class RecommendationRequest
{
    private String mood;
    private String hour;


    // Constructor
    public RecommendationRequest(String mood, String hour)
    {
        this.mood = mood;
        this.hour = hour;
    }


    //GETTERS
    public String getMood() { return mood; }
    public String getHour() { return hour; }


    //SETTERS
    public void setMood(String mood) { this.mood = mood; }
    public void setHour(String hour) { this.hour = hour; }


    @Override
    public String toString() {
        return "RecommendationDTO{" +
                "mood='" + mood + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}