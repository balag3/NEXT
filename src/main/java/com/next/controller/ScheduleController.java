package com.next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.model.meta.ApiResponse;
import com.next.service.BKKService;
import com.next.service.StopService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	BKKService bkkService;
	@Autowired
	StopService stopService;

	@GetMapping(value = "/stop/{stopId}")
	public ApiResponse schedulesForStop(@PathVariable("stopId") String stopId) {
		// TODO: use stopService instead which abstracts away the internal persistence and the BKK calls
		return bkkService.getScheduleForStop(stopId);
	}

}
