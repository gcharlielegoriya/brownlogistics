package com.nihi.bl.driver.model;

import java.sql.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class DriverTripWeekModel {
	

	@Column(name="DRIVER_ID")
	private Integer driverId;
	
	@Column(name="BILL_NAME")
	private String billNo;
	
	@Column(name="DELIVERY_DATE")
	private Date deliveryDate;
	
	@Column(name="ORIGNAME")
	private String origName;
	
	@Column(name="ORIG_CITY_STATE")
		private String origCityState;
	
	@Column(name="DESTNAME")
	private String destName;
	
	@Column(name="DEST_CITY_STATE")
	private String destCityState;
	
	@Column(name="TOTAL_PAY_AMT")
	private long totalPayAmt;
	
	@Column(name="PAID_DATE")
	private Date paidDate;
	
	@Column(name="PAY_DESCRIPTION")
	private String payDescription;
	
	@Column(name="PAPERWORK_RECIEVED")
	private String paperworkRecieved;
	
	@Column(name="PMT_STATE")
	private String pmtState;
	
	@Column(name="DT_INDEX")
	private String dateIndex;
	
	@Column(name="INT_TMSTMP")
	private Date intTimeStamps;
	


}
