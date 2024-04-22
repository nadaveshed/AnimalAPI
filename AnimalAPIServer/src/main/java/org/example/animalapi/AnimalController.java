package org.example.animalapi;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animals")
@CrossOrigin(origins = "http://localhost:3000")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/dogs")
    public ResponseEntity<List<JsonNode>> getAllDogs() {
        List<JsonNode> dogs = animalService.findDogsInAfrica();
        return ResponseEntity.ok(dogs);
    }

    @GetMapping("/cats")
    public  ResponseEntity<List<JsonNode>> getAllCats() {
        List<JsonNode> cats = animalService.findCatsInAfrica();
        return ResponseEntity.ok(cats);
    }
}
