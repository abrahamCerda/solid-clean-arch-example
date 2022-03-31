package com.abraham.solidexample.usecase.impl;

import com.abraham.solidexample.domain.dto.LocationDTO;
import com.abraham.solidexample.domain.entity.Location;
import com.abraham.solidexample.domain.entity.builder.LocationBuilder;
import com.abraham.solidexample.repository.LocationRepository;
import com.abraham.solidexample.usecase.FindSingleLocationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindSingleLocationUseCaseImpl implements FindSingleLocationUseCase {

    private final LocationRepository locationRepository;

    @Autowired
    public FindSingleLocationUseCaseImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location findById(Integer id) {
        LocationDTO locationDTO = this.locationRepository.findById(id);
        return new LocationBuilder()
                .withLocationDTO(locationDTO)
                .build();
    }
}
