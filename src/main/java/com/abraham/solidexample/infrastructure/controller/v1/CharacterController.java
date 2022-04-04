package com.abraham.solidexample.infrastructure.controller.v1;

import com.abraham.solidexample.domain.entity.CharacterEntity;
import com.abraham.solidexample.infrastructure.controller.v1.vo.CharacterVO;
import com.abraham.solidexample.infrastructure.controller.v1.vo.builder.CharacterVOBuilder;
import com.abraham.solidexample.domain.port.input.FindCharacterByIdWithOriginDetailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/character")
public class CharacterController {

    private final FindCharacterByIdWithOriginDetailUseCase findCharacterByIdWithOriginDetailUseCase;

    @Autowired
    public CharacterController(FindCharacterByIdWithOriginDetailUseCase findCharacterByIdWithOriginDetailUseCase) {
        this.findCharacterByIdWithOriginDetailUseCase = findCharacterByIdWithOriginDetailUseCase;
    }

    @GetMapping("/{id}")
    public CharacterVO getCharacterById(@PathVariable("id") Integer id){
        CharacterEntity characterEntity = this.findCharacterByIdWithOriginDetailUseCase.execute(id);
        return new CharacterVOBuilder()
                .withCharacter(characterEntity)
                .build();
    }
}
