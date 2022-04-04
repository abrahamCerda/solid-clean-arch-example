package com.abraham.solidexample.infrastructure.config;

import com.abraham.solidexample.domain.usecase.FindCharacterByIdUseCase;
import com.abraham.solidexample.domain.usecase.FindCharacterByIdWithOriginDetailUseCase;
import com.abraham.solidexample.domain.usecase.FindLocationByIdUseCase;
import com.abraham.solidexample.domain.usecase.impl.FindCharacterByIdUseCaseImpl;
import com.abraham.solidexample.domain.usecase.impl.FindCharacterByIdWithOriginDetailUseCaseImpl;
import com.abraham.solidexample.domain.usecase.impl.FindLocationByIdUseCaseImpl;
import com.abraham.solidexample.infrastructure.gateway.FindCharacterByIdGateway;
import com.abraham.solidexample.infrastructure.gateway.FindLocationByIdGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public FindCharacterByIdUseCase getFindCharacterByIdUseCase(FindCharacterByIdGateway findCharacterByIdGateway){
        return new FindCharacterByIdUseCaseImpl(findCharacterByIdGateway);
    }

    @Bean
    public FindLocationByIdUseCase getFindLocationByIdUseCase(FindLocationByIdGateway findLocationByIdGateway){
        return new FindLocationByIdUseCaseImpl(findLocationByIdGateway);
    }

    @Bean
    public FindCharacterByIdWithOriginDetailUseCase getFindCharacterByIdWithOriginDetailUseCase(FindCharacterByIdGateway findCharacterByIdGateway,
                                                                                                FindLocationByIdGateway findLocationByIdGateway){
        return new FindCharacterByIdWithOriginDetailUseCaseImpl(findCharacterByIdGateway, findLocationByIdGateway);
    }
}
