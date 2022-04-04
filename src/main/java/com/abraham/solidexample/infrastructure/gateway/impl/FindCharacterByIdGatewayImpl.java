package com.abraham.solidexample.infrastructure.gateway.impl;

import com.abraham.solidexample.domain.entity.CharacterEntity;
import com.abraham.solidexample.domain.entity.builder.CharacterBuilder;
import com.abraham.solidexample.infrastructure.client.HttpClient;
import com.abraham.solidexample.infrastructure.gateway.dto.CharacterDTO;
import com.abraham.solidexample.domain.port.output.FindCharacterByIdGateway;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class FindCharacterByIdGatewayImpl implements FindCharacterByIdGateway {

    @Value("${rick-and-morty.api.base-url}")
    private String apiBaseUrl;

    private final HttpClient httpClient;

    @Autowired
    public FindCharacterByIdGatewayImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public CharacterEntity execute(Integer id) {
        String url = this.apiBaseUrl + "/" + "character/" +id;
        CharacterDTO characterDTO = this.httpClient.get(url, CharacterDTO.class);
        return this.buildCharacterEntity(characterDTO);
    }

    @VisibleForTesting
    CharacterEntity buildCharacterEntity (CharacterDTO characterDTO){
        return new CharacterBuilder()
                .withCharacterDTO(characterDTO)
                .build();
    }
}
