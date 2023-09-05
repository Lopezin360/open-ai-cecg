package br.com.open.ai.cecg.OpenAI.impl.http.impl;

import br.com.open.ai.cecg.OpenAI.impl.servise.CallOpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class OpenAIControllerImpl {
    package br.com.open.ai.cecg.OpenAI.http.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.open.ai.cecg.OpenAI.http.;
import br.com.open.ai.cecg.OpenAI.http.data.request.ScienceFictionRequestDTO;

    @RestController
    @RequestMapping(value = "/openai-cecg")
    public record OpenAIControllerImpl(CallOpenAiService service) implements OpenAIController {


        @Override
        @PostMapping(value = "/science-fiction")
        @ResponseStatus(HttpStatus.OK)
        public String generateScienceFiction(@RequestBody ScienceFictionRequestDTO requestDTO) {
            return service.generateScienceFiction(requestDTO);
        }
    }
}
