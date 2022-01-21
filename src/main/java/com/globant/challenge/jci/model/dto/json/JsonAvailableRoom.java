package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JsonAvailableRoom {

  @JsonProperty("room_code")
  private String roomCode;

  @JsonProperty("building_name")
  private String buildingName;

  @JsonProperty("floor")
  private String floorName;

  @JsonProperty("max_allocation")
  private int maxAllocation;

  @JsonProperty("capabilities")
  private Map<Long,String> capabilities;

}