package com.next.model.meta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.next.model.concrete.Route;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
class SingleEntry extends Route { // extends only for test purposes to work with the test url

}
