package br.com.fiap.challenge.controllers;

import br.com.fiap.challenge.services.OpenAIService;
import br.com.fiap.challenge.services.SerpAPIService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class OpenAiController {

    private final OpenAIService openAiService;
    private final SerpAPIService serpService;

    public OpenAiController(OpenAIService openAiService, SerpAPIService serpService) {
        this.openAiService = openAiService;
        this.serpService = serpService;
    }

    @PostMapping("/openai/{topic}")
    public Mono<String> test(@PathVariable String topic) {
        return serpService.makeSearch(topic)
                .flatMap(searchResult -> openAiService.makeRequest(searchResult))
                .map(response -> response.choices().get(0).text());
    }
}
