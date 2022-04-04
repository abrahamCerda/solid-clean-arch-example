package com.abraham.solidexample.infrastructure.gateway.impl;

import com.abraham.solidexample.domain.entity.LocationEntity;
import com.abraham.solidexample.domain.entity.builder.LocationBuilder;
import com.abraham.solidexample.infrastructure.client.HttpClient;
import com.abraham.solidexample.infrastructure.gateway.dto.LocationDTO;
import com.abraham.solidexample.infrastructure.gateway.FindLocationByIdGateway;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class FindLocationByIdGatewayImpl implements FindLocationByIdGateway {

    @Value("${rick-and-morty.api.base-url}")
    private String apiBaseUrl;

    private final HttpClient httpClient;

    @Autowired
    public FindLocationByIdGatewayImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public LocationEntity execute(Integer id) {
        String url = this.apiBaseUrl + "/" + "location/" + id;
        LocationDTO locationDTO = this.httpClient.get(url, LocationDTO.class);
        return this.buildLocationEntity(locationDTO);
    }

    @VisibleForTesting
    LocationEntity buildLocationEntity(LocationDTO locationDTO){
        return new LocationBuilder()
                .withLocationDTO(locationDTO)
                .build();
    }
}
