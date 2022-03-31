package com.abraham.solidexample.resource.v1;

import com.abraham.solidexample.domain.entity.Character;
import com.abraham.solidexample.domain.vo.CharacterVO;
import com.abraham.solidexample.domain.vo.builder.CharacterVOBuilder;
import com.abraham.solidexample.usecase.FindSingleCharacterWithOriginDetailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/character")
public class CharacterResource {

    private final FindSingleCharacterWithOriginDetailUseCase findSingleCharacterWithOriginDetailUseCase;

    @Autowired
    public CharacterResource(FindSingleCharacterWithOriginDetailUseCase findSingleCharacterWithOriginDetailUseCase) {
        this.findSingleCharacterWithOriginDetailUseCase = findSingleCharacterWithOriginDetailUseCase;
    }

    @GetMapping("/{id}")
    public CharacterVO getCharacterById(@PathVariable("id") Integer id){
        Character character = this.findSingleCharacterWithOriginDetailUseCase.findById(id);
        return new CharacterVOBuilder()
                .withCharacter(character)
                .build();
    }
}
