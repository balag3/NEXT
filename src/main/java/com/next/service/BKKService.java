package com.next.service;

import com.next.model.meta.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BKKService {

    private static final String allStopsEndpoint = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/stops-for-location.json";
    private static final String allRoutesEndpoint = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/routes-for-agency.json";
    private static final String allVehiclesEndpoint = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/vehicles-for-location.json";


    @Autowired
    RestTemplate restTemplate;

    public ApiResponse getAllStops() {
        return restTemplate.getForObject(allStopsEndpoint, ApiResponse.class);
    }

    public ApiResponse getAllRoutes() {
        return restTemplate.getForObject(allRoutesEndpoint, ApiResponse.class);
    }

    public ApiResponse getAllVehicles() {
        return restTemplate.getForObject(allVehiclesEndpoint, ApiResponse.class);
    }
}
