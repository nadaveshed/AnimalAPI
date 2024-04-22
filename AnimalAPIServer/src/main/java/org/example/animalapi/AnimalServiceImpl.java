package org.example.animalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private static final List<String> DOGS_IN_AFRICA = Arrays.asList(
            "Azawakh", "Basenji", "Boerboel",
            "Chinese Crested", "Coton de Tulear", "Rhodesian Ridgeback",
            "Saluki", "Sloughi"
    );

    private static final List<String> CATS_IN_AFRICA = Arrays.asList(
            "Abyssinian", "Egyptian Mau", "Sokoke"
    );

    @Override
    @Cacheable(value = "animalCache", key = "'allDogs'")
    public List<JsonNode> findDogsInAfrica() {
        List<JsonNode> dogsData = new ArrayList<>();
        try {
            for (String dog : DOGS_IN_AFRICA) {
                JsonNode dogData = fetchDataForAnimal("dogs", dog);
                dogsData.add(dogData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dogsData;
    }

    @Override
    @Cacheable(value = "animalCache", key = "'allCats'")
    public List<JsonNode> findCatsInAfrica() {
        List<JsonNode> catsData = new ArrayList<>();
        try {
            for (String cat : CATS_IN_AFRICA) {
                JsonNode catData = fetchDataForAnimal("cats", cat);
                catsData.add(catData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catsData;
    }

    private JsonNode fetchDataForAnimal(String animalType, String animal) throws Exception {
        String apiUrl = String.format("https://api.api-ninjas.com/v1/%s?name=%s", animalType, URLEncoder.encode(animal, StandardCharsets.UTF_8));
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-Key", "oMtfQ1n9jSP4TuCR0xZVcw==7mC9VGU4idmXxgJr");
        connection.setRequestProperty("accept", "application/json");
        try (InputStream responseStream = connection.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(responseStream);
        }
    }
}
