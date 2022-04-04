package com.abraham.solidexample.domain.usecase.impl;

import com.abraham.solidexample.domain.entity.Location;
import com.abraham.solidexample.domain.entity.Character;
import com.abraham.solidexample.domain.usecase.FindCharacterByIdUseCase;
import com.abraham.solidexample.domain.usecase.FindCharacterByIdWithOriginDetailUseCase;
import com.abraham.solidexample.domain.usecase.FindLocationByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCharacterByIdWithOriginDetailUseCaseImpl implements FindCharacterByIdWithOriginDetailUseCase {


    private final FindCharacterByIdUseCase findCharacterByIdUseCase;
    private final FindLocationByIdUseCase findLocationByIdUseCase;

    @Autowired
    public FindCharacterByIdWithOriginDetailUseCaseImpl(FindCharacterByIdUseCase findCharacterByIdUseCase,
                                                        FindLocationByIdUseCase findLocationByIdUseCase) {
        this.findCharacterByIdUseCase = findCharacterByIdUseCase;
        this.findLocationByIdUseCase = findLocationByIdUseCase;
    }

    @Override
    public Character execute(Integer id) {
        Character character = this.findCharacterByIdUseCase.execute(id);
        Location origin = character.getOrigin();
        if(origin != null && origin.getUrl() != null  && !origin.getUrl().isEmpty()){
            String[] urlParts = origin.getUrl().trim().split("/");
            int originLocationId = Integer.parseInt(urlParts[urlParts.length -1 ]);
            if(originLocationId >= 0){
                Location originFullLocation = this.findLocationByIdUseCase.execute(originLocationId);
                character.setOrigin(originFullLocation);
            }
        }
        return character;
    }
}
