package com.globant.challenge.jci.application.converter;

import com.globant.challenge.jci.model.dto.json.JsonAvailableRoom;
import com.globant.challenge.jci.model.entity.Capability;
import com.globant.challenge.jci.model.entity.Room;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;

public class RoomToJsonAvailableRoom implements Converter<Room, JsonAvailableRoom> {

  public static final RoomToJsonAvailableRoom INSTANCE = new RoomToJsonAvailableRoom();

  @Override
  public JsonAvailableRoom convert(Room room) {

    return JsonAvailableRoom
        .builder()
        .roomCode(String.valueOf(room.getId()))
        .floorName(room.getFloor().getName())
        .buildingName(room.getFloor().getBuilding().getName())
        .capabilities(room.getCapabilities()
            .stream()
            .collect(Collectors.toMap(Capability::getId,Capability::getName)))
        .maxAllocation(room.getMaxAllocation())
        .build();
  }

  public List<JsonAvailableRoom> convertList(List<Room> rooms){

    return rooms.stream().map(this::convert).collect(Collectors.toList());

  }

}