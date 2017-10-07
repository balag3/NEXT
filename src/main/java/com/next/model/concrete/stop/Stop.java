package com.next.model.concrete.stop;

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
public class Stop extends Entry {

    @JsonProperty("code")
    private String code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("locationType")
    private Integer locationType;

    @JsonProperty("lon")
    private Double lon;

    @JsonProperty("id")
    private String id;

    @JsonProperty("routeIds")
    private List<String> routeIds;

    @JsonProperty("lat")
    private Double lat;

    @JsonProperty("direction")
    private String direction;
}