package com.abraham.solidexample.repository.impl;

import com.abraham.solidexample.client.HttpClient;
import com.abraham.solidexample.domain.dto.CharacterDTO;
import com.abraham.solidexample.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    @Value("${rick-and-morty.api.base-url}")
    private String apiBaseUrl;

    private final HttpClient httpClient;

    @Autowired
    public CharacterRepositoryImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public CharacterDTO findById(Integer id) {
        String url = this.apiBaseUrl + "/" + "character/" +id;
        return this.httpClient.get(url, CharacterDTO.class);
    }
}
