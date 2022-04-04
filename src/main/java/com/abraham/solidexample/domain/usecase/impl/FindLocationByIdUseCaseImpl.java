package com.abraham.solidexample.domain.usecase.impl;

import com.abraham.solidexample.infrastructure.gateway.dto.LocationDTO;
import com.abraham.solidexample.domain.entity.Location;
import com.abraham.solidexample.domain.entity.builder.LocationBuilder;
import com.abraham.solidexample.infrastructure.gateway.LocationRepository;
import com.abraham.solidexample.domain.usecase.FindLocationByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindLocationByIdUseCaseImpl implements FindLocationByIdUseCase {

    private final LocationRepository locationRepository;

    @Autowired
    public FindLocationByIdUseCaseImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location execute(Integer id) {
        LocationDTO locationDTO = this.locationRepository.findById(id);
        return new LocationBuilder()
                .withLocationDTO(locationDTO)
                .build();
    }
}
