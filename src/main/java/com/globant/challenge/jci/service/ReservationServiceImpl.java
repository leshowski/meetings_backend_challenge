package com.globant.challenge.jci.service;

import com.globant.challenge.jci.application.converter.PostRequestBookRoomToReservation;
import com.globant.challenge.jci.application.exception.NotAvailableReservationException;
import com.globant.challenge.jci.application.utils.DateUtils;
import com.globant.challenge.jci.model.dao.ReservationRepository;

import com.globant.challenge.jci.model.dto.json.PostRequestBookRoom;

import com.globant.challenge.jci.model.entity.Reservation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

  public static int CLEAN_UP_BASE_TIME_MINUTES = 5;

  private final ReservationRepository reservationRepository;

  @Autowired
  private ReservationServiceImpl(ReservationRepository reservationRepository){
    this.reservationRepository = reservationRepository;

  }

  public List<Reservation> getListReservation(Long roomId){
    return reservationRepository.findByRoom_id(roomId);
  }

  @Override
  public List<Reservation> getListBookedRooms(Date fromDate) {
    return reservationRepository.findByStartDateAfter(fromDate);
  }

  @Override
  public void saveReservation(PostRequestBookRoom postRequestBookRoom) throws Exception {

    if(isRoomAvailable(postRequestBookRoom.getFromDate(),
        postRequestBookRoom.getTimeSpan(), postRequestBookRoom.getRoomCode())){
      reservationRepository.save(PostRequestBookRoomToReservation.INSTANCE.convert(
          postRequestBookRoom));
    }else{
      throw new NotAvailableReservationException();
    }

  }

  public boolean isRoomAvailable(Date fromDate,int timeSpan,Long roomId){

    List<Reservation> listReservation = getListReservation(roomId);

    return listReservation.
        stream()
        .filter(f->f.getStartDate().compareTo(DateUtils.addMinutesToDate(timeSpan + f.getRoom().getMaxAllocation() + CLEAN_UP_BASE_TIME_MINUTES,
            fromDate))<=0)
        .filter(f-> DateUtils.addMinutesToDate((f.getTimeSpan() + f.getRoom().getMaxAllocation() + CLEAN_UP_BASE_TIME_MINUTES) ,
            f.getStartDate()).compareTo(fromDate)>=0 )
        .count() == 0;

  }

}
