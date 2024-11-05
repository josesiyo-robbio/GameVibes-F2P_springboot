package com.josesiyo_robbio.GameVibes_F2P.request;



public class GameInfoRequest
{
    private String title;
    private String shortDescription;
    private String genre;


    // Constructor
    public GameInfoRequest(String title, String shortDescription, String genre)
    {
        this.title = title;
        this.shortDescription = shortDescription;
        this.genre = genre;
    }


    //GETTERS
    public String getTitle()                { return title;                 }
    public String getShortDescription()     { return shortDescription;      }
    public String getGenre()                { return genre;                 }


    //SETTERS
    public void setTitle(String title)                          { this.title = title;                           }
    public void setShortDescription(String shortDescription)    { this.shortDescription = shortDescription;     }
    public void setGenre(String genre)                          { this.genre = genre;                           }

}