package com.abraham.solidexample.usecase;

import com.abraham.solidexample.domain.entity.Character;

public interface FindSingleCharacterWithOriginDetailUseCase {
    Character findById(Integer id);
}
