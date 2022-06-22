package com.nihi.bl.driver.service;

import java.util.Date;
import java.util.List;

import com.nihi.bl.driver.entity.DriverTripWeekInfoEntity;
import com.nihi.bl.driver.model.DriverDetailsModel;
import com.nihi.bl.driver.model.DriverTripMonthModel;

public interface DriverDetailService{
	public List<DriverDetailsModel> getDriverDetails();
	public DriverTripWeekInfoEntity getWeeklyInfo();
	public DriverTripMonthModel getMonthlyRecords();
	
	public DriverDetailsModel getDriverDetails(String mobileNum);
	
	public List<DriverTripMonthModel> getMonthlyRecords(Date startDate,Date endDate);

}
