package com.next.model.concrete.schedule;

/**
 * Created by JacksonGenerator on 10/1/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class SchedulesItem {
    @JsonProperty("routeId")
    private String routeId;
    @JsonProperty("alertIds")
    private List alertIds;
    @JsonProperty("directions")
    private List<DirectionsItem> directions;
}