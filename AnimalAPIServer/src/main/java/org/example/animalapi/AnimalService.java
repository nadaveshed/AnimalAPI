package org.example.animalapi;


import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface AnimalService {
    List<JsonNode> findDogsInAfrica();
    List<JsonNode> findCatsInAfrica();
}
