package com.abraham.solidexample.domain.entity.builder;

import com.abraham.solidexample.domain.dto.CharacterDTO;
import com.abraham.solidexample.domain.entity.Character;

public class CharacterBuilder {

    private CharacterDTO characterDTO;

    public CharacterBuilder withCharacterDTO(CharacterDTO characterDTO){
        this.characterDTO = characterDTO;
        return this;
    }

    public Character build(){
        if(this.characterDTO == null){
            return null;
        }
        Character character = new Character();
        character.setId(this.characterDTO.getId());
        character.setName(this.characterDTO.getName());
        character.setEpisodes(this.characterDTO.getEpisodes());
        character.setOrigin(new LocationBuilder()
                .withLocationDTO(this.characterDTO.getOrigin())
                .build());
        character.setGender(this.characterDTO.getGender());
        character.setImageUrl(this.characterDTO.getImageUrl());
        character.setLocation(new LocationBuilder()
                .withLocationDTO(this.characterDTO.getLocation())
                .build());
        character.setSpecies(this.characterDTO.getSpecies());
        character.setUrl(this.characterDTO.getUrl());
        character.setStatus(this.characterDTO.getStatus());
        character.setCreated(this.characterDTO.getCreated());
        character.setType(this.characterDTO.getType());
        return character;
    }
}
