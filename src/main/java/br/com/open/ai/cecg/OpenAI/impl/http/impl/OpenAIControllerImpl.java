package br.com.open.ai.cecg.OpenAI.impl.http.impl;

import br.com.open.ai.cecg.OpenAI.impl.http.data.request.MusicasInfantisRequestDTO;
import br.com.open.ai.cecg.OpenAI.impl.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpenAI.impl.service.CallOpenAiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/openai-cecg")
public record OpenAIControllerImpl(CallOpenAiService service) implements OpenAIController {

    @Override
    @PostMapping(value = "/science-fiction")
    @ResponseStatus(HttpStatus.OK)
    public String generateScienceFiction(@RequestBody ScienceFictionRequestDTO requestDTO) {
        return service.generateScienceFiction(requestDTO);
    }
    @Override
    @PostMapping(value = "/musica-infantis")
    @ResponseStatus(HttpStatus.OK)
    public String geradorDeMusicasInfantis (@RequestBody MusicasInfantisRequestDTO requestDTO) {
        return service.geradorDeMusicasInfantis(requestDTO);
    }
}
