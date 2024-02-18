package com.example.javabsuir.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/definition")
public class DefinitionController {

    private static final Map<String, String> definitions = new HashMap<>();

    static {
        definitions.put("Vector", "A quantity having direction as well as magnitude, especially as determining the position of one point in space relative to another.");
        definitions.put("Math", "The abstract science of number, quantity, and space, either as abstract concepts (pure mathematics), or as applied to other disciplines such as physics and engineering (applied mathematics).");
        definitions.put("Picture", "A painting, drawing, photograph, or other representation of a person, object, or scene.");
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getDefinition(@RequestParam String name) {
        String definition = definitions.get(name);
        if (definition != null) {
            Map<String, String> response = new HashMap<>();
            response.put("result", "The result is: " + definition);
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Definition not found for name - " + name);
            return ResponseEntity.status(404).body(errorResponse);
        }
    }
}
