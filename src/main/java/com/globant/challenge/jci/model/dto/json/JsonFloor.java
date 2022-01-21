package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JsonFloor {

  @JsonProperty("name")
  private String name;

  @JsonProperty("rooms")
  private List<JsonRoom> rooms;

}
