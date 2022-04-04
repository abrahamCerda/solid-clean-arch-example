package com.abraham.solidexample.infrastructure.client;

public interface HttpClient {
    <T> T get(String url, Class<T> responseType);
}
