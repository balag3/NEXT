package com.next.controller;

import com.next.model.concrete.vehicle.Location;
import com.next.model.internal.StopDTO;
import com.next.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stop")
public class StopController {

    @Autowired
    StopService stopService;

    //exclude from production
    @GetMapping
    public List<StopDTO> getAllStops() {
        return stopService.getAllStops();
    }

    @GetMapping(value = "/centerLat/{lat}/centerLon/{lon}/radius/{radius}")
    public List<StopDTO> stopsByRadius(@PathVariable("radius") Integer radius,
                                       @PathVariable("lat") Double lat,
                                       @PathVariable("lon") Double lon) {
        Location center = new Location();
        center.setLat(lat);
        center.setLon(lon);
        return stopService.stopsByRadius(radius, center);
    }

}
