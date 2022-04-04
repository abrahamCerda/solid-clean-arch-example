package com.abraham.solidexample.infrastructure.gateway.impl;

import com.abraham.solidexample.infrastructure.client.HttpClient;
import com.abraham.solidexample.infrastructure.gateway.dto.LocationDTO;
import com.abraham.solidexample.infrastructure.gateway.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    @Value("${rick-and-morty.api.base-url}")
    private String apiBaseUrl;

    private final HttpClient httpClient;

    @Autowired
    public LocationRepositoryImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public LocationDTO findById(Integer id) {
        String url = this.apiBaseUrl + "/" + "location/" + id;
        return this.httpClient.get(url, LocationDTO.class);
    }
}
