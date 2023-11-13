package br.com.fiap.challenge.services;

import br.com.fiap.challenge.model.request.ChatGPTRequest;
import br.com.fiap.challenge.model.response.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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
        String question = "Organize em ordem crescente, de acordo com o preço do produto, " +
                "o produto mais barato ao mais caro e me retorne como um json, as chaves do json como por exemplo, title, devem estar entre aspas duplas, além disso, tire os R$ do price, deixe apenas os numeros, se for mais de 2 item, me retorne como um array de json\n"
                + topic;
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


