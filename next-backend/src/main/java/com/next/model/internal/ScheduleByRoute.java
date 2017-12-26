package com.next.model.internal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
public class ScheduleByRoute {

    @Id
    private String id;

    private String routeId;

//    private List<String>
}
