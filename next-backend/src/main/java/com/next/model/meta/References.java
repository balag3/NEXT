package com.next.model.meta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class References {

    @JsonProperty("alerts")
    private Alerts alerts;

    @JsonProperty("routes")
    private Routes routes;

    @JsonProperty("trips")
    private Trips trips;

    @JsonProperty("agencies")
    private Agencies agencies;

    @JsonProperty("stops")
    private Stops stops;
}
