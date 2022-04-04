package com.abraham.solidexample.domain.usecase;

import com.abraham.solidexample.domain.entity.Character;

public interface FindCharacterByIdUseCase {
    Character execute(Integer id);
}
