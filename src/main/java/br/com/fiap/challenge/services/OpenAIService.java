package br.com.fiap.challenge.services;

import br.com.fiap.challenge.model.request.ChatGPTRequest;
import br.com.fiap.challenge.model.response.ChatGPTResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OpenAIService {

    private WebClient webClient;

    public OpenAIService(
            WebClient.Builder builder,
            @Value("${openai.api.key}") String apiKey) {
        this.webClient = builder
                .baseUrl("https://api.openai.com/v1/completions")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization",String.format("Bearer %s", apiKey))
                .build();
    }

    public Mono<ChatGPTResponse> makeRequest(String topic) {
        ChatGPTRequest request = createRequestBody(topic);
        return webClient
                .post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatGPTResponse.class);
    }

    private ChatGPTRequest createRequestBody(String topic) {
        String question = "Organize em ordem crescente, de acordo com o preço do produto, o produto mais barato ao mais caro\n" + topic;
        System.out.println(question);
        return new ChatGPTRequest(
                "text-davinci-003",
                question,
                0.3,
                2000,
                1.0,
                0.0,
                0.0
        );
    }
}


