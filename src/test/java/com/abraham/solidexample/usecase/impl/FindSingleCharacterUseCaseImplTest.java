package com.abraham.solidexample.usecase.impl;

import com.abraham.solidexample.domain.dto.CharacterDTO;
import com.abraham.solidexample.domain.entity.Character;
import com.abraham.solidexample.repository.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class FindSingleCharacterUseCaseImplTest {

    @Mock
    private CharacterRepository characterRepository;

    @Spy
    @InjectMocks
    FindSingleCharacterUseCaseImpl findSingleCharacterUseCase;

    @Test
    public void should_find_character_when_id_is_not_zero(){
        Integer testId = 1;
        CharacterDTO characterDTO = mock(CharacterDTO.class);
        Character character = mock(Character.class);
        doReturn(testId).when(character).getId();
        doReturn(characterDTO).when(this.characterRepository).findById(testId);
        doReturn(character).when(this.findSingleCharacterUseCase).buildCharacter(characterDTO);
        Character resultCharacter = this.findSingleCharacterUseCase.findById(testId);
        verify(this.characterRepository, times(1)).findById(testId);
        verify(this.findSingleCharacterUseCase, times(1)).buildCharacter(characterDTO);
        Assertions.assertEquals(testId, resultCharacter.getId());
    }

}