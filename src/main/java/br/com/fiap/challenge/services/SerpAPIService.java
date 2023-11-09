package br.com.fiap.challenge.services;

import br.com.fiap.challenge.model.entities.ShoppingItem;
import br.com.fiap.challenge.model.response.ShoppingItemResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerpAPIService {

    private final WebClient webClient;

    private final String apiKey;

    public SerpAPIService(
            WebClient.Builder builder,
            @Value("${serpapi.api.key}") String apiKey
    ) {
        this.webClient = builder
                .baseUrl("https://serpapi.com/search")
                .build();
        this.apiKey = apiKey;
    }

    public Mono<String> makeSearch(String searchParam) {
        String searchString = searchParam.replace(" ", "+");
        System.out.println(searchString);

        Mono<String> content = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("engine", "google_shopping")
                        .queryParam("hl", "pt-br")
                        .queryParam("gl", "br")
                        .queryParam("api_key", apiKey)
                        .queryParam("q", searchString)
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class);
        return collectSearchResults(content);
    }

    public Mono<String> collectSearchResults(Mono<String> searchContent) {
        return searchContent.flatMap(jsonResponse -> {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode root = objectMapper.readTree(jsonResponse);
                JsonNode shoppingResults = root.get("shopping_results");

                List<ShoppingItemResponse> shoppingItems = new ArrayList<>();

                if (shoppingResults.isArray()) {
                    int maxItems = 4;
                    for (JsonNode item : shoppingResults) {
                        ShoppingItem shoppingItem = objectMapper.treeToValue(item, ShoppingItem.class);
                        shoppingItems.add(new ShoppingItemResponse(shoppingItem));
                        if (shoppingItems.size() >= maxItems) {
                            break;
                        }
                    }
                }

                return Mono.just(formatShoppingItems(shoppingItems));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Mono.just("");
            }
        });
    }


    public String formatShoppingItems(List<ShoppingItemResponse> shoppingItems) {
        StringBuilder formattedItems = new StringBuilder();

        for (ShoppingItemResponse item : shoppingItems) {
            formattedItems.append("title: ").append(item.title());
            formattedItems.append(" link: ").append(item.link());
            formattedItems.append(" source: ").append(item.source());
            formattedItems.append(" price: ").append(item.price());
            formattedItems.append(" rating: ").append(item.rating());
            formattedItems.append(" thumbnail: ").append(item.thumbnail());
            formattedItems.append(" delivery: ").append(item.delivery());
            formattedItems.append("\n");
        }

        return formattedItems.toString();
    }
}
