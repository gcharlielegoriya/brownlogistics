package com.nihi.bl.driver.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nihi.bl.driver.entity.DriverDetailsEntity;

@Repository
public interface DriverAccountRepository extends JpaRepository<DriverDetailsEntity, Serializable> {
	
	@Query(name="from DriverDetailsEntity where phone=:mobileNumber")
	public DriverDetailsEntity findByPhone(String mobileNumber);
	
	
	
}
