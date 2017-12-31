package com.next.controller;

import com.next.model.concrete.schedule.Schedule;
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
	StopService stopService;

	@GetMapping(value = "/stop/{stopId}")
	public Schedule schedulesForStop(@PathVariable("stopId") String stopId) {
		return stopService.read(stopId).getSchedule();
	}

}
