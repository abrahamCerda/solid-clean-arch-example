package com.abraham.solidexample.domain.usecase;

import com.abraham.solidexample.domain.entity.CharacterEntity;

public interface FindCharacterByIdUseCase {
    CharacterEntity execute(Integer id);
}
