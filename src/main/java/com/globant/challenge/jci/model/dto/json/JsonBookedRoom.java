package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JsonBookedRoom {

  @JsonProperty("room_code")
  private Long roomCode;

  @JsonProperty("room_name")
  private String roomName;

  @JsonProperty("from")
  private Date from;
  @JsonProperty("to")
  private Date to;

}
