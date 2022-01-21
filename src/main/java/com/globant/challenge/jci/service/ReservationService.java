package com.globant.challenge.jci.service;

import com.globant.challenge.jci.model.dto.json.GetRequestAvailableRooms;
import com.globant.challenge.jci.model.dto.json.PostRequestScheduleRoom;
import com.globant.challenge.jci.model.entity.Reservation;
import com.globant.challenge.jci.model.entity.Room;
import java.util.Date;
import java.util.List;

public interface ReservationService {

  public List<Reservation> getListReservation(Long RoomId);

  public List<Reservation> getListBookedRooms(Date fromDate);

  public void saveReservation(PostRequestScheduleRoom postRequestScheduleRoom) throws Exception;

  public boolean isRoomAvailable(Date fromDate,int timeSpan,Long roomId);

}
