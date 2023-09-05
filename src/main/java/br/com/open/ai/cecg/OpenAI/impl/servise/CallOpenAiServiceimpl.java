package br.com.open.ai.cecg.OpenAI.impl.servise;

import br.com.open.ai.cecg.OpenAI.impl.componentes.ChatStreamComponent;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;

import java.util.List;

public class CallOpenAiServiceimpl(ChatStreamComponent streamComponent) implements CallOpenAiService{
    public static final String SCIENCE_FICTION_PROMPT_MESSAGE =
            "Gere uma estória de ficção ciẽntifica de acordo com o " +
                    "sequinte cenário: %s";
    @Override
    public String generationScienceFiction(ScienceFictionRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest = streamComponet.creaChatstreamRequest(List.of(
                new ChatMessage(ChatMenssageRole.SYSTEM.value(),
                        String.format(SCIENCE_FICTION_PROMPT_MESSAGE, requestDTO.scenario()))
        ));
        return streamComponet.getChatStreamResult(chatCompletionRequest);



    }

}
