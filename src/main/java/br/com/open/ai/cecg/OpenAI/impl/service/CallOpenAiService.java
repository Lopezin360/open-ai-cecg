package br.com.open.ai.cecg.OpenAI.impl.service;

import br.com.open.ai.cecg.OpenAI.impl.http.data.request.MusicasInfantisRequestDTO;
import br.com.open.ai.cecg.OpenAI.impl.http.data.request.ScienceFictionRequestDTO;

public interface CallOpenAiService {
    String generateScienceFiction(ScienceFictionRequestDTO requestDTO);

    String geradorDeMusicasInfantis(MusicasInfantisRequestDTO requestDTO);
}