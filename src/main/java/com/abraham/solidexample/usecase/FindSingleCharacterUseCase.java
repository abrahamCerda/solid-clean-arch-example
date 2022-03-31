package com.abraham.solidexample.usecase;

import com.abraham.solidexample.domain.entity.Character;

public interface FindSingleCharacterUseCase {
    Character findById(Integer id);
}
