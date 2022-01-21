package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetRequestAvailableRooms {

  @JsonProperty("building_id")
  private Long buildId;

  @NotNull
  @JsonProperty("from_date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date fromDate;

  @NotNull
  @JsonProperty("time_span")
  private int timeSpan;

  @NotNull
  @JsonProperty("num_attendees")
  private int numAttendees;

  @JsonProperty("capabilities")
  private List<Long> capabilities;


}
