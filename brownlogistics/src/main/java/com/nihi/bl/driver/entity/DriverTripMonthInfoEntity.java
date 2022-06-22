package com.nihi.bl.driver.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "bt_app_cvo_paid")
public class DriverTripMonthInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9176802945318036926L;
	@Id
	@Column(name = "DRIVER_ID")
	private Integer driverId;

	@Column(name = "BILL_NUMBER")
	private String billNo;

	@Column(name = "DELIVERY_DATE")
	private Date deliveryDate;

	@Column(name = "ORIGNAME")
	private String origName;

	@Column(name = "ORIG_CITY_STATE")
	private String origCityState;

	@Column(name = "DESTNAME")
	private String destName;

	@Column(name = "DEST_CITY_STATE")
	private String destCityState;

	@Column(name = "TOTAL_PAY_AMT")
	private long totalPayAmt;

	@Column(name = "PAID_DATE")
	private Date paidDate;

	@Column(name = "PAY_DESCRIPTION")
	private String payDescription;

	@Column(name = "PAPERWORK_RECIEVED")
	private String paperworkRecieved;

	@Column(name = "PMT_STATE")
	private String pmtState;

	@Column(name = "DT_INDEX")
	private String dateIndex;

	@Column(name = "INT_TMSTMP")
	private String intTimeStamps;

}
