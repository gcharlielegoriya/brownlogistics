package com.nihi.bl.driver.model;

public class OtpResponse {
	
	private String statusCode;
	private String statusMessage;
	private Integer otp;
	private Integer driverId;


	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "OtpResponse{" +
				"statusCode='" + statusCode + '\'' +
				", statusMessage='" + statusMessage + '\'' +
				", otp=" + otp +
				", driverId=" + driverId +
				'}';
	}
}
