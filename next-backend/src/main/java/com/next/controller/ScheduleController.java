package com.next.controller;

import com.next.model.internal.Stop;
import com.next.service.BKKService;
import com.next.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	BKKService bkkService;
	@Autowired
	StopService stopService;

	@GetMapping(value = "/stop/{stopId}")
	public Stop schedulesForStop(@PathVariable("stopId") String stopId) {
		return stopService.read(stopId);
	}

}
