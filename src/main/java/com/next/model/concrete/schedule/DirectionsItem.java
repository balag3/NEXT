package com.next.model.concrete.schedule;

/**
 * Created by JacksonGenerator on 10/1/17.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class DirectionsItem {
    @JsonProperty("directionId")
    private String directionId;
    @JsonIgnore
    @JsonProperty("groups")
    private Groups groups;
    @JsonProperty("stopTimes")
    private List<StopTimesItem> stopTimes;
}