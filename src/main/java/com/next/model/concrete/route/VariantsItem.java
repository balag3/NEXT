package com.next.model.concrete.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariantsItem {

    @JsonProperty("headsign")
    private String headsign;

    @JsonProperty("name")
    private String name;

    @JsonProperty("stopIds")
    private List<String> stopIds;

    @JsonProperty("polyline")
    private Polyline polyline;

    @JsonProperty("direction")
    private String direction;
}