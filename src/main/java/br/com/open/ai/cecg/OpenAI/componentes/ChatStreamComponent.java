package br.com.open.ai.cecg.OpenAI.componentes;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;

public class ChatStreamComponent {
    private final OpenAiService openAiService;

    @Value("${openai.model:gpt-3.5-turbo}")
    private String model;
    @Value("${openai.max-tokens:500}")
    private Integer maxtoken;

    public ChatStreamComponent(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }
}
