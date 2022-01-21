package com.globant.challenge.jci.service;

import com.globant.challenge.jci.model.dto.json.GetRequestAvailableRooms;
import com.globant.challenge.jci.model.entity.Room;
import java.util.Date;
import java.util.List;

public interface AvailableRoomService {

  public List<Room> getListAvailableRooms(GetRequestAvailableRooms getRequestAvailableRooms);

}
