package com.next.service;


import com.next.model.meta.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpService {

    @Autowired
    RestTemplate restTemplate;

    public ApiResponse get(String url) {
        return this.restTemplate.getForObject(url, ApiResponse.class);
    }
}
