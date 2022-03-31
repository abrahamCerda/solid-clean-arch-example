package com.abraham.solidexample.repository;

import com.abraham.solidexample.domain.dto.CharacterDTO;

public interface CharacterRepository {
    CharacterDTO findById(Integer id);
}
