package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JsonBuilding {

  @JsonProperty("code")
  Long code;
  @JsonProperty("name")
  String name;

  @JsonProperty("floors")
  List<JsonFloor> floors;

}
