package com.abraham.solidexample.domain.usecase.impl;

import com.abraham.solidexample.domain.entity.CharacterEntity;
import com.abraham.solidexample.infrastructure.gateway.FindCharacterByIdGateway;
import com.abraham.solidexample.domain.usecase.FindCharacterByIdUseCase;

public class FindCharacterByIdUseCaseImpl implements FindCharacterByIdUseCase {

    private final FindCharacterByIdGateway findCharacterByIdGateway;

    public FindCharacterByIdUseCaseImpl(FindCharacterByIdGateway findCharacterByIdGateway) {
        this.findCharacterByIdGateway = findCharacterByIdGateway;
    }

    @Override
    public CharacterEntity execute(Integer id) {
        return this.findCharacterByIdGateway.execute(id);
    }
}
