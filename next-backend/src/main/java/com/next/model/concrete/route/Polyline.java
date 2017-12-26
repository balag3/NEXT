package com.next.model.concrete.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Polyline {

    @JsonProperty("length")
    private Integer length;

    @JsonProperty("levels")
    private String levels;

    @JsonProperty("points")
    private String points;
}