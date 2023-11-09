package br.com.fiap.challenge.controllers;

import br.com.fiap.challenge.model.entities.ShoppingItem;
import br.com.fiap.challenge.services.SerpAPIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class SerpAPIController {

//    private final SerpAPIService service;
//
//    public SerpAPIController(SerpAPIService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/serp")
//    public Mono<List<ShoppingItem>> getA() {
//        return service.search("cafe").map(jsonResponse -> {
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                JsonNode root = objectMapper.readTree(jsonResponse);
//                JsonNode shoppingResults = root.get("shopping_results");
//
//                List<ShoppingItem> shoppingItems = new ArrayList<>();
//
//                if (shoppingResults.isArray()) {
//                    for (JsonNode item : shoppingResults) {
//                        ShoppingItem shoppingItem = objectMapper.treeToValue(item, ShoppingItem.class);
//                        shoppingItems.add(shoppingItem);
//                    }
//                }
//
//                return shoppingItems;
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//                // Handle the exception as needed
//                return Collections.emptyList();
//            }
//        });
//
//    }
}
