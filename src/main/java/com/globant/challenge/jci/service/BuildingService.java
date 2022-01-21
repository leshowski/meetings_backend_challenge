package com.globant.challenge.jci.service;

import com.globant.challenge.jci.model.dto.json.GetRequestAvailableRooms;
import com.globant.challenge.jci.model.entity.Building;
import com.globant.challenge.jci.model.entity.Room;
import java.util.List;

public interface BuildingService {

  public List<Building> getListBuildings();

}
