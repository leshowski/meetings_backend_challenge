package com.globant.challenge.jci.application.converter;

import com.globant.challenge.jci.model.dto.json.JsonBuilding;
import com.globant.challenge.jci.model.dto.json.JsonRoom;
import com.globant.challenge.jci.model.entity.Building;
import com.globant.challenge.jci.model.entity.Capability;
import com.globant.challenge.jci.model.entity.Room;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;

public class RoomToJsonRoom implements Converter<Room, JsonRoom> {

  public static final RoomToJsonRoom INSTANCE = new RoomToJsonRoom();

  @Override
  public JsonRoom convert(Room room) {

    return JsonRoom.builder()
        .code(room.getId())
        .name(room.getName())
        .maxAllocation(room.getMaxAllocation())
        .capabilities(room.getCapabilities()
            .stream()
            .collect(Collectors.toMap(Capability::getId,Capability::getName)))
        .build();
  }

  public List<JsonRoom> convertList(List<Room> rooms){

    return rooms.stream().map(this::convert).collect(Collectors.toList());

  }

}