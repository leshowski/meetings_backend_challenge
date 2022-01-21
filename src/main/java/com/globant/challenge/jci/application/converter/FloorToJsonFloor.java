package com.globant.challenge.jci.application.converter;

import com.globant.challenge.jci.model.dto.json.JsonBuilding;
import com.globant.challenge.jci.model.dto.json.JsonFloor;
import com.globant.challenge.jci.model.entity.Building;
import com.globant.challenge.jci.model.entity.Floor;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;

public class FloorToJsonFloor implements Converter<Floor, JsonFloor> {

  public static final FloorToJsonFloor INSTANCE = new FloorToJsonFloor();

  @Override
  public JsonFloor convert(Floor floor) {

    return JsonFloor.builder()
        .name(floor.getName())
        .rooms(RoomToJsonRoom.INSTANCE.convertList(floor.getRoomList()))
        .build();
  }

  public List<JsonFloor> convertList(List<Floor> floors){

    return floors.stream().map(this::convert).collect(Collectors.toList());

  }

}