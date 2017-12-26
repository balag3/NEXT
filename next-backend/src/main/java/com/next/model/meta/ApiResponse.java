package com.next.model.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {

    @JsonProperty("currentTime")
    private Long currentTime;

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("data")
    private PayLoad data;

    @JsonProperty("text")
    private String text;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("status")
    private String status;
}