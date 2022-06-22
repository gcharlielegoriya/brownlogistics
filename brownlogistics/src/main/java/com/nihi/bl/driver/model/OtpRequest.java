package com.nihi.bl.driver.model;

public class OtpRequest {
	
	private Long mobileNumber;

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "OtpRequest [mobileNumber=" + mobileNumber + "]";
	}
	
	

}
