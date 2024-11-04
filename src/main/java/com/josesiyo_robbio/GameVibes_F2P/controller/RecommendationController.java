package com.josesiyo_robbio.GameVibes_F2P.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.josesiyo_robbio.GameVibes_F2P.exception.ResourceNotFoundException;
import com.josesiyo_robbio.GameVibes_F2P.request.GameInfoRequest;
import com.josesiyo_robbio.GameVibes_F2P.request.RecommendationRequest;
import com.josesiyo_robbio.GameVibes_F2P.response.GameRecommendationResponse;
import com.josesiyo_robbio.GameVibes_F2P.service.GameRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController
{

    @Autowired
    private GameRecommendationService gameRecommendationService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<GameRecommendationResponse> getGameRecommendations(@RequestBody RecommendationRequest recommendationRequest)
    {
        String mood = recommendationRequest.getMood();
        String hour = recommendationRequest.getHour();

        String recommendationTag = gameRecommendationService.getRecommendedTag(mood, hour);
        String url = String.format("https://www.freetogame.com/api/filter?tag=%s&platform=pc", recommendationTag);

        String response = restTemplate.getForObject(url, String.class);
        if (response == null || response.isEmpty())
        {
            throw new ResourceNotFoundException("No games found for the specified tag.");
        }

        JsonArray gamesArray = JsonParser.parseString(response).getAsJsonArray();
        if (gamesArray.size() == 0)
        {
            throw new ResourceNotFoundException("No games found for the specified mood and hour.");
        }

        List<GameInfoRequest> gameInfoRequestList = new ArrayList<>();
        for (JsonElement gameElement : gamesArray) {
            JsonObject game = gameElement.getAsJsonObject();
            String title = game.get("title").getAsString();
            String shortDescription = game.get("short_description").getAsString();
            String genre = game.get("genre").getAsString();

            GameInfoRequest gameInfoRequest = new GameInfoRequest(title, shortDescription, genre);
            gameInfoRequestList.add(gameInfoRequest);
        }

        GameRecommendationResponse gameRecommendationResponse = new GameRecommendationResponse(gameInfoRequestList);
        return ResponseEntity.ok(gameRecommendationResponse);
    }
}