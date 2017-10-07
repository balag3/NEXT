package com.next.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StopsForLocationSearchCriteria {

    @NonNull
    private String lat;

    @NonNull
    private String lon;

    @NonNull
    private String radius;

}
