package com.globant.challenge.jci.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.globant.challenge.jci.model.dto.json.GetRequestAvailableRooms;
import com.globant.challenge.jci.model.dto.json.PostRequestScheduleRoom;
import com.globant.challenge.jci.model.dto.json.ResponseAvailableRooms;
import com.globant.challenge.jci.model.dto.json.ResponseBookedRooms;
import com.globant.challenge.jci.model.dto.json.ResponseBuildings;
import com.globant.challenge.jci.model.dto.json.ResponseScheduleRoom;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MeetingRequestAPI {


  @GetMapping(path = "/buildings", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseBuildings> getBuildings();

  @GetMapping(path = "/availableRooms", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseAvailableRooms> availableRooms(
      @RequestBody @Valid GetRequestAvailableRooms getRequestAvailableRooms
  );

  @PostMapping(path = "/scheduleRoom", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseScheduleRoom> scheduleRoom(
      @RequestBody @Valid PostRequestScheduleRoom postRequestScheduleRoom
  ) throws Exception;

  @GetMapping(path = "/bookedRooms", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseBookedRooms> bookedRooms(
      @RequestParam(value="fromDate", required = false) @DateTimeFormat(pattern="yyyyMMdd")Date fromDate);

}