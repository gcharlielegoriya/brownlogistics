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
@Table(name = "bt_app_cvo_crrnt_wk_pay")
public class DriverTripWeekInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6109696454709289912L;
	
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
	private Double totalPayAmt;

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
	private Date intTimeStamps;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrigName() {
		return origName;
	}

	public void setOrigName(String origName) {
		this.origName = origName;
	}

	public String getOrigCityState() {
		return origCityState;
	}

	public void setOrigCityState(String origCityState) {
		this.origCityState = origCityState;
	}

	public String getDestName() {
		return destName;
	}

	public void setDestName(String destName) {
		this.destName = destName;
	}

	public String getDestCityState() {
		return destCityState;
	}

	public void setDestCityState(String destCityState) {
		this.destCityState = destCityState;
	}

	public Double getTotalPayAmt() {
		return totalPayAmt;
	}

	public void setTotalPayAmt(Double totalPayAmt) {
		this.totalPayAmt = totalPayAmt;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getPayDescription() {
		return payDescription;
	}

	public void setPayDescription(String payDescription) {
		this.payDescription = payDescription;
	}

	public String getPaperworkRecieved() {
		return paperworkRecieved;
	}

	public void setPaperworkRecieved(String paperworkRecieved) {
		this.paperworkRecieved = paperworkRecieved;
	}

	public String getPmtState() {
		return pmtState;
	}

	public void setPmtState(String pmtState) {
		this.pmtState = pmtState;
	}

	public String getDateIndex() {
		return dateIndex;
	}

	public void setDateIndex(String dateIndex) {
		this.dateIndex = dateIndex;
	}

	public Date getIntTimeStamps() {
		return intTimeStamps;
	}

	public void setIntTimeStamps(Date intTimeStamps) {
		this.intTimeStamps = intTimeStamps;
	}

	@Override
	public String toString() {
		return "DriverTripWeekInfoEntity{" +
				"driverId=" + driverId +
				", billNo='" + billNo + '\'' +
				", deliveryDate=" + deliveryDate +
				", origName='" + origName + '\'' +
				", origCityState='" + origCityState + '\'' +
				", destName='" + destName + '\'' +
				", destCityState='" + destCityState + '\'' +
				", totalPayAmt=" + totalPayAmt +
				", paidDate=" + paidDate +
				", payDescription='" + payDescription + '\'' +
				", paperworkRecieved='" + paperworkRecieved + '\'' +
				", pmtState='" + pmtState + '\'' +
				", dateIndex='" + dateIndex + '\'' +
				", intTimeStamps=" + intTimeStamps +
				'}';
	}
}
