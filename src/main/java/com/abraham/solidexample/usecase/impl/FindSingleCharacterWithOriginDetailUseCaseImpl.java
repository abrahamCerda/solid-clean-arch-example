package com.abraham.solidexample.usecase.impl;

import com.abraham.solidexample.domain.entity.Location;
import com.abraham.solidexample.domain.entity.Character;
import com.abraham.solidexample.usecase.FindSingleCharacterUseCase;
import com.abraham.solidexample.usecase.FindSingleCharacterWithOriginDetailUseCase;
import com.abraham.solidexample.usecase.FindSingleLocationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindSingleCharacterWithOriginDetailUseCaseImpl implements FindSingleCharacterWithOriginDetailUseCase {


    private final FindSingleCharacterUseCase findSingleCharacterUseCase;
    private final FindSingleLocationUseCase findSingleLocationUseCase;

    @Autowired
    public FindSingleCharacterWithOriginDetailUseCaseImpl(FindSingleCharacterUseCase findSingleCharacterUseCase,
                                                          FindSingleLocationUseCase findSingleLocationUseCase) {
        this.findSingleCharacterUseCase = findSingleCharacterUseCase;
        this.findSingleLocationUseCase = findSingleLocationUseCase;
    }

    @Override
    public Character findById(Integer id) {
        Character character = this.findSingleCharacterUseCase.findById(id);
        Location origin = character.getOrigin();
        if(origin != null && origin.getUrl() != null  && !origin.getUrl().isBlank()){
            String[] urlParts = origin.getUrl().trim().split("/");
            int originLocationId = Integer.parseInt(urlParts[urlParts.length -1 ]);
            if(originLocationId >= 0){
                Location originFullLocation = this.findSingleLocationUseCase.findById(originLocationId);
                character.setOrigin(originFullLocation);
            }
        }
        return character;
    }
}
