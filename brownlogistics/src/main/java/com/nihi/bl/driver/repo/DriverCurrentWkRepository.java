package com.nihi.bl.driver.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nihi.bl.driver.entity.DriverTripWeekInfoEntity;

@Repository
public interface DriverCurrentWkRepository extends JpaRepository<DriverTripWeekInfoEntity, Long> {

    @Query(name="from DriverTripWeekInfoEntity where driverId=:driverId")
    public List<DriverTripWeekInfoEntity> getDetailByDriverId(Integer driverId);

}
