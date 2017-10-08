package com.next.model.internal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@Builder
public class StopInfo {

    @Id
    private String id;

    private String name;

    private Integer locationType;

    private List<String> routeIds;

    private Double lon;

    private Double lat;

    private String direction;

}
