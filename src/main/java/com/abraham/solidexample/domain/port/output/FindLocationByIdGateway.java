package com.abraham.solidexample.domain.port.output;

import com.abraham.solidexample.domain.entity.LocationEntity;

public interface FindLocationByIdGateway {
    LocationEntity execute(Integer id);
}
