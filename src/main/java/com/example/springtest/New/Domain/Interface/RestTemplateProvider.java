package com.example.springtest.New.Domain.Interface;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {
    RestTemplate getRestTemplate();
}
