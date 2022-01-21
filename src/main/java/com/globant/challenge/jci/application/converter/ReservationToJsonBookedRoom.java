package com.globant.challenge.jci.application.converter;

import com.globant.challenge.jci.application.utils.DateUtils;
import com.globant.challenge.jci.model.dto.json.JsonBookedRoom;
import com.globant.challenge.jci.model.dto.json.JsonBuilding;
import com.globant.challenge.jci.model.entity.Building;
import com.globant.challenge.jci.model.entity.Reservation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;

public class ReservationToJsonBookedRoom implements Converter<Reservation, JsonBookedRoom> {

  public static final ReservationToJsonBookedRoom INSTANCE = new ReservationToJsonBookedRoom();

  @Override
  public JsonBookedRoom convert(Reservation reservation) {

    return JsonBookedRoom.builder()
        .from(reservation.getStartDate())
        .to(DateUtils.addMinutesToDate(reservation.getTimeSpan(), reservation.getStartDate()))
        .roomCode(reservation.getRoom().getId())
        .roomName(reservation.getRoom().getName())
        .build();
  }

  public List<JsonBookedRoom> convertList(List<Reservation> reservations){

    return reservations.stream().map(this::convert).collect(Collectors.toList());

  }

}