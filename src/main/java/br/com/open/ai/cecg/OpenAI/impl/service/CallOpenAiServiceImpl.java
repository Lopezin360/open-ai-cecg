package br.com.open.ai.cecg.OpenAI.impl.service;

import br.com.open.ai.cecg.OpenAI.impl.componentes.ChatStreamComponent;
import br.com.open.ai.cecg.OpenAI.impl.http.data.request.MusicasInfantisRequestDTO;
import br.com.open.ai.cecg.OpenAI.impl.http.data.request.ScienceFictionRequestDTO;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CallOpenAiServiceImpl(ChatStreamComponent streamComponent) implements CallOpenAiService {

    public static final String SCIENCE_FICTION_PROMPT_MESSAGE =
            "Gere uma estória de ficção científica de acordo com o " +
                    "seguinte cenário: %s";

    @Override
    public String generateScienceFiction(ScienceFictionRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(SCIENCE_FICTION_PROMPT_MESSAGE, requestDTO.scenario()))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }
    public static final String MUSICAS_INFANTIS_PROMPT_MENSAGE =
            "Gere uma música infantil" +
                    "seguindo o cenário: %s";

    @Override
    public String geradorDeMusicasInfantis(MusicasInfantisRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(MUSICAS_INFANTIS_PROMPT_MENSAGE, requestDTO.infantil()))
                ));
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }
}
