package com.globant.challenge.jci.application.converter;

import com.globant.challenge.jci.model.dto.json.PostRequestBookRoom;
import com.globant.challenge.jci.model.entity.Reservation;
import com.globant.challenge.jci.model.entity.Room;
import org.springframework.core.convert.converter.Converter;

public class PostRequestBookRoomToReservation implements Converter<PostRequestBookRoom, Reservation> {

  public static final PostRequestBookRoomToReservation INSTANCE = new PostRequestBookRoomToReservation();

  @Override
  public Reservation convert(PostRequestBookRoom postRequestBookRoom) {
    return Reservation
            .builder()
        .startDate(postRequestBookRoom.getFromDate())
        .timeSpan(postRequestBookRoom.getTimeSpan())
        .room(Room.builder().id(postRequestBookRoom.getRoomCode()).build())
        .build();
  }

}
