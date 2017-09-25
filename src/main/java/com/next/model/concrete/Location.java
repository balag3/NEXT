package com.next.model.concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Location {

    @JsonProperty("lon")
    private Double lon;

    @JsonProperty("lat")
    private Double lat;
}