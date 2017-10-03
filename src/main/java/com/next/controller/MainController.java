package com.next.controller;

import com.next.model.meta.ApiResponse;
import com.next.service.BKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController(value = "/")
public class MainController {

    private final RestTemplate restTemplate;

    @Autowired
    BKKService bkkService;

    //the url fetches a single route's details
    private static String singleRoute = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/route-details.json?routeId=BKK_4720";

    //schedule
    private static String schedule = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/schedule-for-stop.json?stopId=BKK_F01072";

    @Autowired
    public MainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ApiResponse getSingleRoute() {
        return restTemplate.getForObject(singleRoute, ApiResponse.class);
    }

    @GetMapping(value = "/routes")
    public ApiResponse routes() {
        return bkkService.getAllRoutes();
    }

    @GetMapping(value = "/vehicles")
    public ApiResponse vehicles() {
        return bkkService.getAllVehicles();
    }

    @GetMapping(value = "/stops")
    public ApiResponse stops() {
        return bkkService.getAllStops();
    }
}
