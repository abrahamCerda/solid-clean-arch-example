package com.abraham.solidexample.domain.vo.builder;

import com.abraham.solidexample.domain.entity.Character;
import com.abraham.solidexample.domain.vo.CharacterVO;

public class CharacterVOBuilder {
    private Character character;

    public CharacterVOBuilder withCharacter(Character character){
        this.character = character;
        return this;
    }

    public CharacterVO build(){
        if(this.character == null){
            return null;
        }
        CharacterVO characterVO = new CharacterVO();
        characterVO.setId(this.character.getId());
        characterVO.setName(this.character.getName() != null ? this.character.getName() : "");
        characterVO.setType(this.character.getType() != null ? this.character.getType() : "");
        characterVO.setSpecies(this.character.getSpecies() != null ? this.character.getSpecies() : "");
        characterVO.setStatus(this.character.getStatus() != null ? this.character.getStatus() : "");
        characterVO.setEpisodeCount(this.character.getEpisodes() != null ?
                this.character.getEpisodes().size() : 0);
        characterVO.setOrigin(new LocationVOBuilder()
                .withLocationDTO(this.character.getOrigin())
                .build());
        return characterVO;
    }
}
