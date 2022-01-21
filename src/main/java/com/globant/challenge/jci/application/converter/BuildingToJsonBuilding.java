package com.globant.challenge.jci.application.converter;

import com.globant.challenge.jci.model.dto.json.JsonAvailableRoom;
import com.globant.challenge.jci.model.dto.json.JsonBuilding;
import com.globant.challenge.jci.model.entity.Building;
import com.globant.challenge.jci.model.entity.Capability;
import com.globant.challenge.jci.model.entity.Room;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;

public class BuildingToJsonBuilding implements Converter<Building, JsonBuilding> {

  public static final BuildingToJsonBuilding INSTANCE = new BuildingToJsonBuilding();

  @Override
  public JsonBuilding convert(Building building) {

    return JsonBuilding.builder()
        .code(building.getId())
        .name(building.getName())
        .floors(FloorToJsonFloor.INSTANCE.convertList(building.getFloorList()))
        .build();
  }

  public List<JsonBuilding> convertList(List<Building> buildings){

    return buildings.stream().map(this::convert).collect(Collectors.toList());

  }

}