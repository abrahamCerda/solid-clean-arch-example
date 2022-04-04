package com.abraham.solidexample.domain.usecase;

import com.abraham.solidexample.domain.entity.LocationEntity;

public interface FindLocationByIdUseCase {
    LocationEntity execute(Integer id);
}
