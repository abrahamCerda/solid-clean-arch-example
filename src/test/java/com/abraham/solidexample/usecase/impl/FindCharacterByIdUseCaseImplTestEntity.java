package com.abraham.solidexample.usecase.impl;

import com.abraham.solidexample.infrastructure.gateway.dto.CharacterDTO;
import com.abraham.solidexample.domain.entity.CharacterEntity;
import com.abraham.solidexample.domain.usecase.impl.FindCharacterByIdUseCaseImpl;
import com.abraham.solidexample.infrastructure.gateway.FindCharacterByIdGateway;
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
class FindCharacterByIdUseCaseImplTestEntity {

    @Mock
    private FindCharacterByIdGateway findCharacterByIdGateway;

    @Spy
    @InjectMocks
    FindCharacterByIdUseCaseImpl findSingleCharacterUseCase;

    @Test
    public void should_find_character_when_id_is_not_zero(){
        Integer testId = 1;
        CharacterDTO characterDTO = mock(CharacterDTO.class);
        CharacterEntity characterEntity = mock(CharacterEntity.class);
        doReturn(testId).when(characterEntity).getId();
        doReturn(characterDTO).when(this.findCharacterByIdGateway).execute(testId);
        doReturn(characterEntity).when(this.findSingleCharacterUseCase).buildCharacter(characterDTO);
        CharacterEntity resultCharacterEntity = this.findSingleCharacterUseCase.execute(testId);
        verify(this.findCharacterByIdGateway, times(1)).execute(testId);
        verify(this.findSingleCharacterUseCase, times(1)).buildCharacter(characterDTO);
        Assertions.assertEquals(testId, resultCharacterEntity.getId());
    }

}