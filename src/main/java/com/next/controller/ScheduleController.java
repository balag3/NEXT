package com.next.controller;


import com.next.model.meta.ApiResponse;
import com.next.service.BKKService;
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

    @GetMapping(value = "/stop/{stopId}")
    public ApiResponse schedulesForStop(@PathVariable("stopId") String stopId) {
        return bkkService.getScheduleForStop(stopId);
    }

}
