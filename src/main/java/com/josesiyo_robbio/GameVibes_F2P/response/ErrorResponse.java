package com.josesiyo_robbio.GameVibes_F2P.response;



public class ErrorResponse
{
    private String message;

    public ErrorResponse(String message)
    {
        this.message = message;
    }


    //GETTERS AND SETTERS
    public String getMessage()              { return message;           }
    public void setMessage(String message)  { this.message = message;   }

}