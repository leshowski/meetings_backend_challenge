package com.globant.challenge.jci.service;

import com.globant.challenge.jci.model.dao.BuildingRepository;
import com.globant.challenge.jci.model.dao.RoomRepository;
import com.globant.challenge.jci.model.dto.json.GetRequestAvailableRooms;
import com.globant.challenge.jci.model.entity.Building;
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
public class BuildingServiceImpl implements BuildingService {

  private final BuildingRepository buildingRepository;


  @Autowired
  private BuildingServiceImpl(BuildingRepository buildingRepository){
    this.buildingRepository = buildingRepository;
  }

  @Override
  public List<Building> getListBuildings() {

    return buildingRepository.findAll();

  }

}
