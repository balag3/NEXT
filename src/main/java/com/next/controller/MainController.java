package com.next.controller;

import com.next.model.meta.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController(value = "/")
public class MainController {

    private final RestTemplate restTemplate;

    //the url fetches a single route's details
    private static String singleRoute = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/route-details.json?routeId=BKK_4720";

    // fetches a list of vehicles, currently not working
    private static String allVehiclesForLocation = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/vehicles-for-location.json";


    @Autowired
    public MainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ApiResponse getSingle() {
        return restTemplate.getForObject(singleRoute, ApiResponse.class);
    }

    @GetMapping(value = "/list")
    public ApiResponse getList() {
        return restTemplate.getForObject(allVehiclesForLocation, ApiResponse.class);
    }
}
