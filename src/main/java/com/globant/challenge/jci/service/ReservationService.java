package com.globant.challenge.jci.service;

import com.globant.challenge.jci.model.dto.json.PostRequestBookRoom;
import com.globant.challenge.jci.model.entity.Reservation;
import java.util.Date;
import java.util.List;

public interface ReservationService {

  public List<Reservation> getListReservation(Long RoomId);

  public List<Reservation> getListBookedRooms(Date fromDate);

  public void saveReservation(PostRequestBookRoom postRequestBookRoom) throws Exception;

  public boolean isRoomAvailable(Date fromDate,int timeSpan,Long roomId);

}
