package com.next.model.concrete.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.next.configuration.EntryDeserializer;
import com.next.model.meta.Entry;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = EntryDeserializer.None.class)
public class Vehicle extends Entry{

    @JsonProperty("serviceDate")
    private String serviceDate;

    @JsonProperty("bearing")
    private Double bearing;

    @JsonProperty("stopId")
    private String stopId;

    @JsonProperty("vehicleRouteType")
    private String vehicleRouteType;

    @JsonProperty("label")
    private String label;

    @JsonProperty("stopDistancePercent")
    private Integer stopDistancePercent;

    @JsonProperty("routeId")
    private String routeId;

    @JsonProperty("licensePlate")
    private String licensePlate;

    @JsonProperty("congestionLevel")
    private Object congestionLevel;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("deviated")
    private Boolean deviated;

    @JsonProperty("vehicleId")
    private String vehicleId;

    @JsonProperty("lastUpdateTime")
    private Integer lastUpdateTime;

    @JsonProperty("status")
    private String status;
}