package com.abraham.solidexample.domain.usecase.impl;

import com.abraham.solidexample.domain.entity.CharacterEntity;
import com.abraham.solidexample.domain.entity.LocationEntity;
import com.abraham.solidexample.domain.port.input.FindCharacterByIdWithOriginDetailUseCase;
import com.abraham.solidexample.domain.port.output.FindCharacterByIdGateway;
import com.abraham.solidexample.domain.port.output.FindLocationByIdGateway;

public class FindCharacterByIdWithOriginDetailUseCaseImpl implements FindCharacterByIdWithOriginDetailUseCase {

    private final FindCharacterByIdGateway findCharacterByIdGateway;
    private final FindLocationByIdGateway findLocationByIdGateway;

    public FindCharacterByIdWithOriginDetailUseCaseImpl(FindCharacterByIdGateway findCharacterByIdGateway,
                                                        FindLocationByIdGateway findLocationByIdGateway) {
        this.findCharacterByIdGateway = findCharacterByIdGateway;
        this.findLocationByIdGateway = findLocationByIdGateway;
    }

    @Override
    public CharacterEntity execute(Integer id) {
        CharacterEntity characterEntity = this.findCharacterByIdGateway.execute(id);
        LocationEntity origin = characterEntity.getOrigin();
        if(origin != null && origin.getUrl() != null  && !origin.getUrl().isEmpty()){
            String[] urlParts = origin.getUrl().trim().split("/");
            int originLocationId = Integer.parseInt(urlParts[urlParts.length -1 ]);
            if(originLocationId >= 0){
                LocationEntity originFullLocationEntity = this.findLocationByIdGateway.execute(originLocationId);
                characterEntity.setOrigin(originFullLocationEntity);
            }
        }
        return characterEntity;
    }
}
