package com.abraham.solidexample.usecase;

import com.abraham.solidexample.domain.entity.Location;

public interface FindSingleLocationUseCase {
    Location findById(Integer id);
}
