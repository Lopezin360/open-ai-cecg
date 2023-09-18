package br.com.open.ai.cecg.OpenAI.impl.http.impl;

import br.com.open.ai.cecg.OpenAI.impl.http.data.request.MusicasInfantisRequestDTO;
import br.com.open.ai.cecg.OpenAI.impl.http.data.request.ScienceFictionRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface OpenAIController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    String generateScienceFiction(@RequestBody ScienceFictionRequestDTO requestDTO);

    @PostMapping(value = "/musica-infantis")
    @ResponseStatus(HttpStatus.OK)
    String geradorDeMusicasInfantis (@RequestBody MusicasInfantisRequestDTO requestDTO);
}