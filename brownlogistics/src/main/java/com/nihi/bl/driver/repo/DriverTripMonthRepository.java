package com.nihi.bl.driver.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nihi.bl.driver.entity.DriverTripMonthInfoEntity;

@Repository
public interface DriverTripMonthRepository extends JpaRepository<DriverTripMonthInfoEntity, Serializable> {

	//@Query(value = "from DriverTripMonthInfoEntity BETWEEN :startDate AND :endDate")
	//public List<DriverTripMonthInfoEntity> findByDate(Date startDate,Date endDate);

    @Query(value = "from DriverTripMonthInfoEntity where billNo=:billNo")
    public List<DriverTripMonthInfoEntity> findByBillNo(String billNo);
    
    @Query(value = "from DriverTripMonthInfoEntity where billNo=:billNo and driver_id=:driverId")
    public List<DriverTripMonthInfoEntity> findByBillNoAndDriverId(String billNo,String driverId);
    
}
