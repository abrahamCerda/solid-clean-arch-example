package com.abraham.solidexample.domain.port.output;

import com.abraham.solidexample.domain.entity.CharacterEntity;

public interface FindCharacterByIdGateway {
    CharacterEntity execute(Integer id);
}
