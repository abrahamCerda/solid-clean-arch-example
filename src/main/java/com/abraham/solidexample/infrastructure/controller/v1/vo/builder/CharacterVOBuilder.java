package com.abraham.solidexample.infrastructure.controller.v1.vo.builder;

import com.abraham.solidexample.domain.entity.CharacterEntity;
import com.abraham.solidexample.infrastructure.controller.v1.vo.CharacterVO;

public class CharacterVOBuilder {
    private CharacterEntity characterEntity;

    public CharacterVOBuilder withCharacter(CharacterEntity characterEntity){
        this.characterEntity = characterEntity;
        return this;
    }

    public CharacterVO build(){
        if(this.characterEntity == null){
            return null;
        }
        CharacterVO characterVO = new CharacterVO();
        characterVO.setId(this.characterEntity.getId());
        characterVO.setName(this.characterEntity.getName() != null ? this.characterEntity.getName() : "");
        characterVO.setType(this.characterEntity.getType() != null ? this.characterEntity.getType() : "");
        characterVO.setSpecies(this.characterEntity.getSpecies() != null ? this.characterEntity.getSpecies() : "");
        characterVO.setStatus(this.characterEntity.getStatus() != null ? this.characterEntity.getStatus() : "");
        characterVO.setEpisodeCount(this.characterEntity.getEpisodes() != null ?
                this.characterEntity.getEpisodes().size() : 0);
        characterVO.setOrigin(new LocationVOBuilder()
                .withLocationDTO(this.characterEntity.getOrigin())
                .build());
        return characterVO;
    }
}
