package com.globant.challenge.jci.model.dao;

import com.globant.challenge.jci.model.entity.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

  public List<Room> findByFloor_Building_id(Long buildingID);

}
