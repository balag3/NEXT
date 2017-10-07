package com.next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.model.StopsForLocationSearchCriteria;
import com.next.model.meta.ApiResponse;
import com.next.service.BKKService;

@RestController
@RequestMapping("/stop")
public class StopController {

	@Autowired
	BKKService bkkService;

	@GetMapping
	public ApiResponse stops() {
		return bkkService.getAllStops();
	}

	@GetMapping(value = "/lat/{lat}/lon/{lon}/radius/{radius}")
	public ApiResponse getStopsForLocation(@PathVariable("lat") String lat, @PathVariable("lon") String lon, @PathVariable("radius") String radius) {

		// TODO: no need for criteria object here, just pass lat, lon, radius as separate parameters to bkkService, keep it simple and stupid :)
		StopsForLocationSearchCriteria criteria = StopsForLocationSearchCriteria.builder().lat(lat).lon(lon).radius(radius).build();

		return bkkService.getStopsForLocation(criteria);
	}

}
