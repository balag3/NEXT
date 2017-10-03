package com.next.model.concrete.schedule;

/**
 * Created by JacksonGenerator on 10/1/17.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.next.configuration.EntryDeserializer;
import com.next.model.meta.Entry;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = EntryDeserializer.None.class)
public class Schedule extends Entry {
    @JsonProperty("serviceDate")
    private String serviceDate;
    @JsonProperty("alertIds")
    private List alertIds;
    @JsonProperty("schedules")
    private List<SchedulesItem> schedules;
    @JsonProperty("stopId")
    private String stopId;
    @JsonProperty("routeIds")
    private List<String> routeIds;
}