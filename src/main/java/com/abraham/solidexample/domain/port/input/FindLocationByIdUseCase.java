package com.abraham.solidexample.domain.port.input;

import com.abraham.solidexample.domain.entity.LocationEntity;

public interface FindLocationByIdUseCase {
    LocationEntity execute(Integer id);
}
