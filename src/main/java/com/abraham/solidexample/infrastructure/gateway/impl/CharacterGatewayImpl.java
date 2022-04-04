package com.abraham.solidexample.infrastructure.gateway.impl;

import com.abraham.solidexample.infrastructure.client.HttpClient;
import com.abraham.solidexample.infrastructure.gateway.dto.CharacterDTO;
import com.abraham.solidexample.infrastructure.gateway.CharacterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterGatewayImpl implements CharacterGateway {

    @Value("${rick-and-morty.api.base-url}")
    private String apiBaseUrl;

    private final HttpClient httpClient;

    @Autowired
    public CharacterGatewayImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public CharacterDTO findById(Integer id) {
        String url = this.apiBaseUrl + "/" + "character/" +id;
        return this.httpClient.get(url, CharacterDTO.class);
    }
}
