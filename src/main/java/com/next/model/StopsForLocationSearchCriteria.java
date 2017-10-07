package com.next.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
// TODO: no need for criteria object here, just pass lat, lon, radius as separate parameters to bkkService, keep it simple and stupid :)
public class StopsForLocationSearchCriteria {

    @NonNull
    private String lat;

    @NonNull
    private String lon;

    @NonNull
    private String radius;

}
