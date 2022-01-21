package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseScheduleRoom {

  @JsonProperty("http_status")
  private int httpStatus;

  @JsonProperty("user_message")
  private String message;

  @JsonProperty("details")
  private String details;

}
