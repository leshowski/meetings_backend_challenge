package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseBuildings {

  @JsonProperty("buildings")
  List<JsonBuilding> jsonBuildings;


}