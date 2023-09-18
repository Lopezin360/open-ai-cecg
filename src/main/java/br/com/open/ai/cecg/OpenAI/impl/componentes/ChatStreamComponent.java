package br.com.open.ai.cecg.OpenAI.impl.componentes;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionChunk;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class ChatStreamComponent {
    private final OpenAiService openAiService;

    @Value("${openai.model:gpt-3.5-turbo}")
    private String model;
    @Value("${openai.max-tokens:500}")
    private Integer maxtoken;

    public ChatStreamComponent(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public String getChatStreamResult(ChatCompletionRequest chatCopletionrequest) {
        StringBuilder sb = new StringBuilder();
        openAiService.streamChatCompletion(chatCopletionrequest)
                .flatMapIterable(ChatCompletionChunk::getChoices)
                .filter(c -> c.getMessage() != null)
                .map(ChatCompletionChoice::getMessage)
                .filter(c -> c.getContent() != null)
                .map(ChatMessage::getContent)
                .doOnError(Throwable::printStackTrace)
                .doOnNext(sb::append)
                .blockingLast();
        return sb.toString();
    }

    public ChatCompletionRequest createChatStreamRequest(List<ChatMessage> menssages) {
        return ChatCompletionRequest
                .builder()
                .model(model)
                .messages(menssages)
                .n(1)
                .maxTokens(maxtoken)
                .logitBias(new HashMap<>())
                .build();
    }
}

