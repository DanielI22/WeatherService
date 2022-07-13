package com.example.springtest.New.Domain.Implementation;

import com.example.springtest.New.Domain.Interface.RestTemplateProvider;
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
