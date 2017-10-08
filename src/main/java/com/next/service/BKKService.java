package com.next.service;

import com.next.model.meta.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BKKService {

    //TODO make individual service for all controller

    private static final String allStopsEndpoint = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/stops-for-location.json";
    private static final String allRoutesEndpoint = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/routes-for-agency.json";
    private static final String allVehiclesEndpoint = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/vehicles-for-location.json";
    //schedule
    private static String schedule = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/schedule-for-stop.json";
    private static String stopsForLocation = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/stops-for-location.json";
    private static String routeDetails = "http://futar.bkk.hu/bkk-utvonaltervezo-api/ws/otp/api/where/route-details.json";


    @Autowired
    HttpService httpService;

    public ApiResponse getRouteById(String routeId) {

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(routeDetails)
                .query("routeId={routeId}")
                .buildAndExpand(routeId);

        String uri = uriComponents.toUriString();

        return httpService.get(uri);
    }

    public ApiResponse getAllStops() {
        return httpService.get(allStopsEndpoint);
    }

    public ApiResponse getAllRoutes() {
        return httpService.get(allRoutesEndpoint);
    }

    public ApiResponse getAllVehicles() {
        return httpService.get(allVehiclesEndpoint);
    }

    public ApiResponse getScheduleForStop(String stopId) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(schedule)
                .query("stopId={stopId}")
                .buildAndExpand(stopId);
        String uri = uriComponents.toUriString();
        return httpService.get(uri);
    }

    public ApiResponse getStopsForLocation(String lat, String lon, String radius) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(stopsForLocation)
                .query("lat={lat}")
                .query("lat={lon}")
                .query("radius={radius}")
                .query("includeReferences=false")
                .buildAndExpand(lat, lon, radius);
        String uri = uriComponents.toUriString();
        return httpService.get(uri);
    }
}
