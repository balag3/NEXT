package com.next.model.meta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
class PayLoad {

    @JsonProperty("entry")
    private SingleEntry entry; // In case of a single return value from concrete types

    @JsonProperty("list")
    private ListEntry list; // In case of a list of return values from concrete types //TODO implement a Type that works

    @JsonProperty("references")
    private References references;

    @JsonProperty("class")
    private String _class;

    @JsonProperty("limitExceeded")
    private Boolean limitExceeded;
}
