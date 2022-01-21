package com.globant.challenge.jci.application.converter;

import com.globant.challenge.jci.model.dto.json.PostRequestScheduleRoom;
import com.globant.challenge.jci.model.entity.Reservation;
import com.globant.challenge.jci.model.entity.Room;
import org.springframework.core.convert.converter.Converter;

public class PostRequestScheduleRoomToReservation implements Converter<PostRequestScheduleRoom, Reservation> {

  public static final PostRequestScheduleRoomToReservation INSTANCE = new PostRequestScheduleRoomToReservation();

  @Override
  public Reservation convert(PostRequestScheduleRoom postRequestScheduleRoom) {
    return Reservation
            .builder()
        .startDate(postRequestScheduleRoom.getFromDate())
        .timeSpan(postRequestScheduleRoom.getTimeSpan())
        .room(Room.builder().id(postRequestScheduleRoom.getRoomCode()).build())
        .build();
  }

}
