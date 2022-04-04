package com.abraham.solidexample.usecase.impl;

import com.abraham.solidexample.infrastructure.gateway.dto.CharacterDTO;
import com.abraham.solidexample.domain.entity.CharacterEntity;
import com.abraham.solidexample.domain.usecase.impl.FindCharacterByIdUseCaseImpl;
import com.abraham.solidexample.domain.port.output.FindCharacterByIdGateway;
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
class FindCharacterByIdUseCaseImplTest {

    @Mock
    private FindCharacterByIdGateway findCharacterByIdGateway;

    @Spy
    @InjectMocks
    FindCharacterByIdUseCaseImpl findSingleCharacterUseCase;

    @Test
    public void should_find_character_when_id_is_not_zero(){
        Integer testId = 1;
        CharacterEntity characterEntity = mock(CharacterEntity.class);
        doReturn(testId).when(characterEntity).getId();
        doReturn(characterEntity).when(this.findCharacterByIdGateway).execute(testId);
        CharacterEntity resultCharacterEntity = this.findSingleCharacterUseCase.execute(testId);
        verify(this.findCharacterByIdGateway, times(1)).execute(testId);
        Assertions.assertEquals(testId, resultCharacterEntity.getId());
    }

}