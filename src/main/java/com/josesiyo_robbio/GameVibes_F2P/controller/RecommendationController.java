package com.josesiyo_robbio.GameVibes_F2P.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.josesiyo_robbio.GameVibes_F2P.dto.GameInfo;
import com.josesiyo_robbio.GameVibes_F2P.dto.RecommendationDTO;
import com.josesiyo_robbio.GameVibes_F2P.service.GameRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private GameRecommendationService gameRecommendationService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public List<GameInfo> getGameRecommendations(@RequestBody RecommendationDTO recommendationDTO) {
        String mood = recommendationDTO.getMood();
        String hour = recommendationDTO.getHour();

        String recommendationTag = gameRecommendationService.getRecommendedTag(mood, hour);

        String url = String.format("https://www.freetogame.com/api/filter?tag=%s&platform=pc", recommendationTag);

        // Llama a la API de FreeToGame
        String response = restTemplate.getForObject(url, String.class);

        // Parsea la respuesta JSON y extrae los campos necesarios
        JsonArray gamesArray = JsonParser.parseString(response).getAsJsonArray();
        List<GameInfo> gameInfoList = new ArrayList<>();

        for (JsonElement gameElement : gamesArray) {
            JsonObject game = gameElement.getAsJsonObject();
            String title = game.get("title").getAsString();
            String shortDescription = game.get("short_description").getAsString();
            String genre = game.get("genre").getAsString();

            GameInfo gameInfo = new GameInfo(title, shortDescription, genre);
            gameInfoList.add(gameInfo);
        }

        return gameInfoList;
    }
}