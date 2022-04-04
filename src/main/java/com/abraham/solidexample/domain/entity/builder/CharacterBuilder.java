package com.abraham.solidexample.domain.entity.builder;

import com.abraham.solidexample.infrastructure.gateway.dto.CharacterDTO;
import com.abraham.solidexample.domain.entity.CharacterEntity;

public class CharacterBuilder {

    private CharacterDTO characterDTO;

    public CharacterBuilder withCharacterDTO(CharacterDTO characterDTO){
        this.characterDTO = characterDTO;
        return this;
    }

    public CharacterEntity build(){
        if(this.characterDTO == null){
            return null;
        }
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(this.characterDTO.getId());
        characterEntity.setName(this.characterDTO.getName());
        characterEntity.setEpisodes(this.characterDTO.getEpisodes());
        characterEntity.setOrigin(new LocationBuilder()
                .withLocationDTO(this.characterDTO.getOrigin())
                .build());
        characterEntity.setGender(this.characterDTO.getGender());
        characterEntity.setImageUrl(this.characterDTO.getImageUrl());
        characterEntity.setLocation(new LocationBuilder()
                .withLocationDTO(this.characterDTO.getLocation())
                .build());
        characterEntity.setSpecies(this.characterDTO.getSpecies());
        characterEntity.setUrl(this.characterDTO.getUrl());
        characterEntity.setStatus(this.characterDTO.getStatus());
        characterEntity.setCreated(this.characterDTO.getCreated());
        characterEntity.setType(this.characterDTO.getType());
        return characterEntity;
    }
}
