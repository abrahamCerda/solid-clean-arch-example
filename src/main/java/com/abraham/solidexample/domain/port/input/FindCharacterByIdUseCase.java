package com.abraham.solidexample.domain.port.input;

import com.abraham.solidexample.domain.entity.CharacterEntity;

public interface FindCharacterByIdUseCase {
    CharacterEntity execute(Integer id);
}
