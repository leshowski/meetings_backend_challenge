package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@AllArgsConstructor
public class PostRequestBookRoom {

  @NotNull
  @JsonProperty("room_code")
  private Long roomCode;
  @NotNull
  @JsonProperty("from")
  @DateTimeFormat(iso = ISO.DATE)
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date fromDate;
  @NotNull
  @JsonProperty("time_span")
  private int timeSpan;


}
