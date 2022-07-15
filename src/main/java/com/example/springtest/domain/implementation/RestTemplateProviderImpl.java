package com.example.springtest.domain.implementation;

import com.example.springtest.domain.interfaces.RestTemplateProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateProviderImpl implements RestTemplateProvider {
    public RestTemplateProviderImpl() {

    }

    @Override
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
