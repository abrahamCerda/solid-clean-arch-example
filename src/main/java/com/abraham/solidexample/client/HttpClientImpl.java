package com.abraham.solidexample.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class HttpClientImpl implements HttpClient{

    private final WebClient webClient;

    @Autowired
    public HttpClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public <T> T get(String url, Class<T> responseType){
        Mono<T> response = this.webClient.get().uri(url)
                .exchangeToMono(res -> {
            if(!res.statusCode().is2xxSuccessful()){
                return res.createException().flatMap(Mono::error);
            }
            return res.bodyToMono(responseType);
        });
        return response.block();
    }
}
