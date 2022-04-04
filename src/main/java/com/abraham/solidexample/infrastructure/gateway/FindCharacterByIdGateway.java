package com.abraham.solidexample.infrastructure.gateway;

import com.abraham.solidexample.domain.entity.CharacterEntity;

public interface FindCharacterByIdGateway {
    CharacterEntity execute(Integer id);
}
