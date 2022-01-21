package com.globant.challenge.jci.model.dao;

import com.globant.challenge.jci.model.entity.Building;
import com.globant.challenge.jci.model.entity.Room;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {


}
