package com.abraham.solidexample.domain.port.input;

import com.abraham.solidexample.domain.entity.CharacterEntity;

public interface FindCharacterByIdWithOriginDetailUseCase {
    CharacterEntity execute(Integer id);
}
