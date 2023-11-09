package br.com.fiap.challenge.model.response;

import java.util.List;

public record ChatGPTResponse(
        List<Choice> choices
) { }

