package com.josesiyo_robbio.GameVibes_F2P.response;

import com.josesiyo_robbio.GameVibes_F2P.request.GameInfoRequest;
import java.util.List;



public class GameRecommendationResponse
{
    private List<GameInfoRequest> games;

    public GameRecommendationResponse(List<GameInfoRequest> games)
    {
        this.games = games;
    }

    public List<GameInfoRequest> getGames()
    {
        return games;
    }

    public void setGames(List<GameInfoRequest> games)
    {
        this.games = games;
    }
}
