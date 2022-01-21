package com.globant.challenge.jci.controller;

import com.globant.challenge.jci.application.converter.BuildingToJsonBuilding;
import com.globant.challenge.jci.application.converter.ReservationToJsonBookedRoom;
import com.globant.challenge.jci.application.converter.RoomToJsonAvailableRoom;
import com.globant.challenge.jci.application.utils.DateUtils;
import com.globant.challenge.jci.model.dto.json.GetRequestAvailableRooms;
import com.globant.challenge.jci.model.dto.json.PostRequestBookRoom;
import com.globant.challenge.jci.model.dto.json.ResponseAvailableRooms;
import com.globant.challenge.jci.model.dto.json.ResponseBookedRooms;
import com.globant.challenge.jci.model.dto.json.ResponseBuildings;
import com.globant.challenge.jci.model.dto.json.ResponseBookRoom;
import com.globant.challenge.jci.service.AvailableRoomService;
import com.globant.challenge.jci.service.BuildingService;
import com.globant.challenge.jci.service.ReservationService;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingRequestResource implements MeetingRequestAPI {

  public static String CREATED_ROOM_MESSAGE = "Booked room";

  private AvailableRoomService availableRoomService;
  private ReservationService reservationService;
  private BuildingService buildingService;

  @Autowired
  public MeetingRequestResource(AvailableRoomService availableRoomService,
                                ReservationService reservationService,
      BuildingService buildingService){
    this.availableRoomService = availableRoomService;
    this.reservationService = reservationService;
    this.buildingService = buildingService;
  }

  @Override
  public ResponseEntity<ResponseBuildings> getBuildings() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            ResponseBuildings.builder()
                .jsonBuildings(
                    BuildingToJsonBuilding.INSTANCE.convertList(buildingService.getListBuildings()))
                .build());
  }

  @Override
  public ResponseEntity<ResponseAvailableRooms> availableRooms(
      GetRequestAvailableRooms getRequestAvailableRooms) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(
            ResponseAvailableRooms.builder()
                .jsonAvailableRooms(RoomToJsonAvailableRoom.INSTANCE.convertList(
                    availableRoomService
                        .getListAvailableRooms(getRequestAvailableRooms)
                ))
                .build());
  }

  @Override
  public ResponseEntity<ResponseBookRoom> bookRoom(
      PostRequestBookRoom postRequestBookRoom) throws Exception {
    reservationService.saveReservation(postRequestBookRoom);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            ResponseBookRoom.builder()
                    .httpStatus(HttpStatus.CREATED.value())
                        .message(CREATED_ROOM_MESSAGE)
                            .details(postRequestBookRoom.getRoomCode() +
                                " "+ postRequestBookRoom.getTimeSpan() +
                                " "+ postRequestBookRoom.getFromDate())
                                .build()
            );

  }

  @Override
  public ResponseEntity<ResponseBookedRooms> bookedRooms(Date fromDate) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(
            ResponseBookedRooms.builder()
                .jsonBookedRooms(
                    ReservationToJsonBookedRoom.INSTANCE.convertList(
                        reservationService.getListBookedRooms(
                            Optional.ofNullable(fromDate).orElse(DateUtils.todayAtMidnight()))))
                .build());
  }

}
