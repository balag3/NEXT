package com.next.controller;

import com.next.model.internal.StopInfo;
import com.next.model.meta.ApiResponse;
import com.next.service.BKKService;
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
	BKKService bkkService;

	@Autowired
	StopService stopService;
	
	@GetMapping
	public ApiResponse stops() {
		return bkkService.getAllStops();
	}

	@GetMapping(value = "/lat/{lat}/lon/{lon}/radius/{radius}")
	public List<StopInfo> getStopsForLocation(@PathVariable("lat") String lat, @PathVariable("lon") String lon, @PathVariable("radius") String radius) {
		return stopService.getStopInfo(lat, lon, radius);
	}

}
