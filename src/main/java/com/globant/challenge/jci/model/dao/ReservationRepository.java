package com.globant.challenge.jci.model.dao;

import com.globant.challenge.jci.model.entity.Reservation;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

  public List<Reservation> findByRoom_id(Long room);

  public List<Reservation> findByStartDateAfter(Date startDate);

}
