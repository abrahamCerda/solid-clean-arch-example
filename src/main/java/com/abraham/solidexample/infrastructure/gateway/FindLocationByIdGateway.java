package com.abraham.solidexample.infrastructure.gateway;

import com.abraham.solidexample.domain.entity.LocationEntity;

public interface FindLocationByIdGateway {
    LocationEntity execute(Integer id);
}
