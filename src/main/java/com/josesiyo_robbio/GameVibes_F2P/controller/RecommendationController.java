package com.josesiyo_robbio.GameVibes_F2P.controller;

import com.josesiyo_robbio.GameVibes_F2P.dto.RecommendationDTO;
import com.josesiyo_robbio.GameVibes_F2P.service.GameRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private GameRecommendationService gameRecommendationService;

    @Autowired
    private RestTemplate restTemplate; // Se inyecta RestTemplate

    @PostMapping
    public String getGameRecommendations(@RequestBody RecommendationDTO recommendationDTO) {
        String mood = recommendationDTO.getMood();
        String hour = recommendationDTO.getHour();

        String recommendationTag = gameRecommendationService.getRecommendedTag(mood, hour);

        String url = String.format("https://www.freetogame.com/api/filter?tag=%s&platform=pc", recommendationTag);

        // Llama a la API de FreeToGame
        String response = restTemplate.getForObject(url, String.class);

        return response; // Retorna la respuesta de la API
    }
}
