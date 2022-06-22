package com.nihi.bl.driver.model;

import java.sql.Date;

import lombok.Data;
@Data
public class DriverTripMonthModel {

	//private DriverDetailsEntity driverId;
	private String billNo;
	private Date deliveryDate;
	private String origName;
	private String origCityState;
	private String destName;
	private String destCityState;
	private long totalPayAmt;
	private Date paidDate;
	private String payDescription;
	private String paperworkRecieved;
	private String pmtState;
	private String dateIndex;
	private Date intTimeStamps;
	
	

}
