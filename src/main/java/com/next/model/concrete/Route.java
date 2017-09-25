package com.next.model.concrete;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

    @JsonProperty("iconDisplayType")
    private String iconDisplayType;

    @JsonProperty("color")
    private String color;

    @JsonProperty("description")
    private String description;

    @JsonProperty("agencyId")
    private String agencyId;

    @JsonProperty("variants")
    private List<VariantsItem> variants;

    @JsonProperty("type")
    private String type;

    @JsonProperty("textColor")
    private String textColor;

    @JsonProperty("url")
    private Object url;

    @JsonProperty("alertIds")
    private List alertIds;

    @JsonProperty("iconDisplayText")
    private String iconDisplayText;

    @JsonProperty("bikesAllowed")
    private Boolean bikesAllowed;

    @JsonProperty("id")
    private String id;

    @JsonProperty("shortName")
    private String shortName;

    @JsonProperty("longName")
    private Object longName;
}