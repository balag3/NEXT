package com.next.model.concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class Polyline {

    @JsonProperty("length")
    private Integer length;

    @JsonProperty("levels")
    private String levels;

    @JsonProperty("points")
    private String points;
}