package com.abraham.solidexample.usecase.impl;

import com.abraham.solidexample.domain.dto.CharacterDTO;
import com.abraham.solidexample.domain.entity.Character;
import com.abraham.solidexample.domain.entity.builder.CharacterBuilder;
import com.abraham.solidexample.repository.CharacterRepository;
import com.abraham.solidexample.usecase.FindSingleCharacterUseCase;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindSingleCharacterUseCaseImpl implements FindSingleCharacterUseCase {

    private final CharacterRepository characterRepository;

    @Autowired
    public FindSingleCharacterUseCaseImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        CharacterDTO characterDTO = this.characterRepository.findById(id);
        return this.buildCharacter(characterDTO);
    }

    @VisibleForTesting
    Character buildCharacter(CharacterDTO characterDTO){
        return new CharacterBuilder()
                .withCharacterDTO(characterDTO)
                .build();
    }
}
