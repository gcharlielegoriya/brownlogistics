package com.nihi.bl.driver.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="BT_APP_CVO_INFO")
public class DriverDetailsEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 321209522914213029L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="DRIVER_ID",unique = true, nullable = false)
	private Integer driverId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PHONE#")
	private String phone;
	
	@CreationTimestamp
	@Column(name="INS_TMSTMP")
	private Date INS_TMSTMP;

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getINS_TMSTMP() {
		return INS_TMSTMP;
	}

	public void setINS_TMSTMP(Date iNS_TMSTMP) {
		INS_TMSTMP = iNS_TMSTMP;
	}

	@Override
	public String toString() {
		return "DriverDetailsEntity [driverId=" + driverId + ", name=" + name + ", phone=" + phone + ", INS_TMSTMP="
				+ INS_TMSTMP + "]";
	}
	
	
}
