package com.globant.challenge.jci.service;

import com.globant.challenge.jci.model.dao.RoomRepository;
import com.globant.challenge.jci.model.dto.json.GetRequestAvailableRooms;
import com.globant.challenge.jci.model.entity.Capability;
import com.globant.challenge.jci.model.entity.Room;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailableRoomServiceImpl implements AvailableRoomService {

  private final RoomRepository roomRepository;
  private final ReservationService reservationService;

  @Autowired
  private AvailableRoomServiceImpl(RoomRepository roomRepository,
                                   ReservationService reservationService){
    this.roomRepository = roomRepository;
    this.reservationService = reservationService;
  }

  @Override
  public List<Room> getListAvailableRooms(GetRequestAvailableRooms getRequestAvailableRooms) {

    List<Room> roomList = Boolean.FALSE.equals(Objects.isNull(getRequestAvailableRooms.getBuildId()))?
                            Objects.requireNonNull(
                                roomRepository.findByFloor_Building_id(getRequestAvailableRooms.getBuildId())):
                            roomRepository.findAll();

    return roomList.stream()
        .filter(f -> f.getMaxAllocation() >= getRequestAvailableRooms.getNumAttendees())
        .filter(
            f ->
                f.getCapabilities().stream()
                    .map(Capability::getId)
                    .collect(Collectors.toList())
                    .containsAll(
                        Optional.ofNullable(getRequestAvailableRooms.getCapabilities()).orElse(
                            Collections.EMPTY_LIST)))
        .filter(
            f ->
                reservationService.isRoomAvailable(
                    getRequestAvailableRooms.getFromDate(),
                    getRequestAvailableRooms.getTimeSpan(),
                    f.getId()))
        .sorted(Comparator.comparing(Room::getMaxAllocation))
        .collect(Collectors.toList());

  }

}
