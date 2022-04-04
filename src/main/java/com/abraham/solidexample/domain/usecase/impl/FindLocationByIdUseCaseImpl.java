package com.abraham.solidexample.domain.usecase.impl;

import com.abraham.solidexample.domain.entity.LocationEntity;
import com.abraham.solidexample.domain.port.output.FindLocationByIdGateway;
import com.abraham.solidexample.domain.port.input.FindLocationByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindLocationByIdUseCaseImpl implements FindLocationByIdUseCase {

    private final FindLocationByIdGateway findLocationByIdGateway;

    @Autowired
    public FindLocationByIdUseCaseImpl(FindLocationByIdGateway findLocationByIdGateway) {
        this.findLocationByIdGateway = findLocationByIdGateway;
    }

    @Override
    public LocationEntity execute(Integer id) {
        return this.findLocationByIdGateway.execute(id);
    }
}
