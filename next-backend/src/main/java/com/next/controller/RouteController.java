package com.next.controller;


import com.next.model.meta.ApiResponse;
import com.next.service.BKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    BKKService bkkService;


    @GetMapping
    public ApiResponse routes() {
        return bkkService.getAllRoutes();
    }

    @GetMapping(value = "/{routeId}")
    public ApiResponse getRouteById(@PathVariable("routeId") String routeId) {
        return bkkService.getRouteById(routeId);
    }

}
