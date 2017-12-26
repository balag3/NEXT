package com.next.model.concrete.schedule;

/**
 * Created by JacksonGenerator on 10/1/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class StopTimesItem {

    @JsonProperty("departureTime")
    private Integer departureTime;

    @JsonProperty("predictedDepartureTime")
    private Integer predictedDepartureTime;

    @JsonProperty("serviceDate")
    private String serviceDate;

    @JsonProperty("arrivalTime")
    private Integer arrivalTime;

    @JsonProperty("wheelchairAccessible")
    private Boolean wheelchairAccessible;

    @JsonProperty("groupIds")
    private List<String> groupIds;

    @JsonProperty("tripId")
    private String tripId;

    @JsonProperty("predictedArrivalTime")
    private Integer predictedArrivalTime;
}