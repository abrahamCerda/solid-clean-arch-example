package com.abraham.solidexample.domain.usecase.impl;

import com.abraham.solidexample.infrastructure.gateway.dto.CharacterDTO;
import com.abraham.solidexample.domain.entity.Character;
import com.abraham.solidexample.domain.entity.builder.CharacterBuilder;
import com.abraham.solidexample.infrastructure.gateway.CharacterGateway;
import com.abraham.solidexample.domain.usecase.FindCharacterByIdUseCase;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCharacterByIdUseCaseImpl implements FindCharacterByIdUseCase {

    private final CharacterGateway characterGateway;

    @Autowired
    public FindCharacterByIdUseCaseImpl(CharacterGateway characterGateway) {
        this.characterGateway = characterGateway;
    }

    @Override
    public Character execute(Integer id) {
        CharacterDTO characterDTO = this.characterGateway.findById(id);
        return this.buildCharacter(characterDTO);
    }

    @VisibleForTesting
    Character buildCharacter(CharacterDTO characterDTO){
        return new CharacterBuilder()
                .withCharacterDTO(characterDTO)
                .build();
    }
}
