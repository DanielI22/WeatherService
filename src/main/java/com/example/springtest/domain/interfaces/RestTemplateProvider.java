package com.example.springtest.domain.interfaces;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {
    RestTemplate getRestTemplate();
}
