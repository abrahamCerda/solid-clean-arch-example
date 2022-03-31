package com.abraham.solidexample.client;

public interface HttpClient {
    <T> T get(String url, Class<T> responseType);
}
