package com.josesiyo_robbio.GameVibes_F2P.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josesiyo_robbio.GameVibes_F2P.model.Mood; // Asegúrate de importar el modelo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class GameRecommendationService {

    private final ResourceLoader resourceLoader;
    private List<Mood> moodList; // Cambiado a lista de Mood
    private Map<String, List<String>> hourTags;

    @Autowired
    public GameRecommendationService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    private void init() {
        loadMoods();
        loadHours();
    }

    private void loadMoods() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = resourceLoader.getResource("classpath:moods.json").getInputStream();
            moodList = Arrays.asList(objectMapper.readValue(inputStream, Mood[].class)); // Cambiado para deserializar en lista de Mood
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHours() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = resourceLoader.getResource("classpath:hours.json").getInputStream();
            hourTags = objectMapper.readValue(inputStream, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRecommendedTag(String mood, String hour) {
        // Encuentra el Mood correspondiente
        Mood selectedMood = moodList.stream()
                .filter(m -> m.getName().equals(mood))
                .findFirst()
                .orElse(null);

        String category = getRandomFromList(selectedMood.getCategories());
        String tag = getRandomFromList(hourTags.get(hour));
        return category + "." + tag;
    }

    private String getRandomFromList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
