package com.nihi.bl.driver.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihi.bl.driver.entity.DriverDetailsEntity;
import com.nihi.bl.driver.entity.DriverTripWeekInfoEntity;
import com.nihi.bl.driver.model.DriverDetailsModel;
import com.nihi.bl.driver.model.DriverTripMonthModel;
import com.nihi.bl.driver.repo.DriverAccountRepository;

@Service
public class DriverDetailServiceImpl implements DriverDetailService {

	@Autowired(required = true)
	private DriverAccountRepository driverRepository;

	/*
	 * this method is used to fetch all records from the driver table
	 */
	@Override
	public List<DriverDetailsModel> getDriverDetails() {
		List<DriverDetailsModel> driverList = new ArrayList<DriverDetailsModel>();

		List<DriverDetailsEntity> entity = driverRepository.findAll();
		if (entity.isEmpty()) {

		} else {
			for (DriverDetailsEntity driverEntity : entity) {
				DriverDetailsModel model = new DriverDetailsModel();
				BeanUtils.copyProperties(driverEntity, model);
				driverList.add(model);
			}
		}
		return driverList;
	}

	
	/*
	 * this method used to get Driver data by using mobile number
	 */
	@Override
	public DriverDetailsModel getDriverDetails(String mobileNumber) {
		DriverDetailsEntity entity=new DriverDetailsEntity();
		DriverDetailsModel model=new DriverDetailsModel();
		try {
			entity=driverRepository.findByPhone(mobileNumber);
			if(entity==null) {
				
			}else {
				// sample data 
				BeanUtils.copyProperties(entity, model);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	@Override
	public DriverTripWeekInfoEntity getWeeklyInfo() {
		return null;
	}
	/*
	 * this method used to get the data of trip for specific user/driver
	 * between 2 dates
	 */

	/*
	 * @Override public List<DriverTripMonthModel> getMonthlyRecords(Date
	 * startDate,Date endDate) { //DriverTripMonthInfoEntity entity=new
	 * DriverTripMonthInfoEntity(); List<DriverTripMonthModel> listTripPaid=new
	 * ArrayList<DriverTripMonthModel>(); List<DriverTripMonthInfoEntity>
	 * driverTripPaidEntity=driverMonthRepository.findByDate(startDate, endDate);
	 * 
	 * 
	 * if (driverTripPaidEntity.isEmpty()) {
	 * 
	 * } else { for (DriverTripMonthInfoEntity driverTripEntity :
	 * driverTripPaidEntity) { DriverTripMonthModel model = new
	 * DriverTripMonthModel(); BeanUtils.copyProperties(driverTripEntity, model);
	 * listTripPaid.add(model); } } return listTripPaid; }
	 * 
	 */	@Override
	public DriverTripMonthModel getMonthlyRecords() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DriverTripMonthModel> getMonthlyRecords(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}



}
