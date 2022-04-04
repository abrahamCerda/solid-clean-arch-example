package com.abraham.solidexample.infrastructure.gateway;

import com.abraham.solidexample.infrastructure.gateway.dto.CharacterDTO;

public interface CharacterGateway {
    CharacterDTO findById(Integer id);
}
