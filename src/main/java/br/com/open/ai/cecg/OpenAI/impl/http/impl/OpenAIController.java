package br.com.open.ai.cecg.OpenAI.impl.http.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OpenAIController {
    package br.com.open.ai.cecg.OpenAI.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;

    public interface OpenAIController {

        @PostMapping
        @ResponseStatus(HttpStatus.OK)
        String generateScienceFiction(@RequestBody Request.ScienceFictionRequestDTO requestDTO);

    }
}
