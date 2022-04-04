package com.abraham.solidexample.domain.usecase;

import com.abraham.solidexample.domain.entity.Location;

public interface FindLocationByIdUseCase {
    Location execute(Integer id);
}
