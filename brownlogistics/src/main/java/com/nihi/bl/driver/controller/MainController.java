package com.nihi.bl.driver.controller;

import com.nihi.bl.driver.entity.DriverTripMonthInfoEntity;
import com.nihi.bl.driver.entity.DriverTripWeekInfoEntity;
import com.nihi.bl.driver.model.*;
import com.nihi.bl.driver.repo.DriverCurrentWkRepository;
import com.nihi.bl.driver.repo.DriverTripMonthRepository;
import com.nihi.bl.driver.service.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihi.bl.driver.entity.DriverDetailsEntity;
import com.nihi.bl.driver.repo.DriverAccountRepository;

import java.util.List;

@RestController
public class MainController {

	@Autowired(required = true)
	private DriverAccountRepository driverRepository;

	@Autowired(required = true)
	private DriverCurrentWkRepository driverCurrentWkRepository;

	@Autowired(required = true)
	public DriverTripMonthRepository driverTripMonthRepository;

	@GetMapping(value = "/test")
	public String project() {
		System.out.println("project started");
		return "success";
	}

	@PostMapping(value = "/getOtp")
	public OtpResponse getOtp(@RequestBody OtpRequest request) {
		OtpResponse res = new OtpResponse();

		SmsService sms = new SmsService();

		try {
			System.out.println("Inside getOtp method : request : " + request.toString());

			if (request.getMobileNumber() == null) {
				res.setStatusCode("0001");
				res.setStatusMessage("Mobile Number can't be blank");
				return res;
			}
			DriverDetailsEntity entity = new DriverDetailsEntity();
			entity.setPhone(String.valueOf(request.getMobileNumber()));
			entity = driverRepository.findByPhone(String.valueOf(request.getMobileNumber()));
			if (entity == null) {
				res.setStatusCode("0002");
				res.setStatusMessage("Invalid Mobile Number");
				return res;
			}
			Integer driverId = entity.getDriverId();
			System.out.println("driverId : " + driverId);
			int min = 1000;
			int max = 9999;
			int number = (int) (Math.random() * (max - min + 1) + min);

			// for sending the sms
			//sms.send(String.valueOf(request.getMobileNumber()));
			sms.send("+12247729591");
			res.setStatusCode("0000");
			res.setStatusMessage("Success");
			res.setOtp(number);
			res.setDriverId(driverId);

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatusCode("1111");
			res.setStatusMessage("Fail");
			return res;
		}
	}

	/*
	 * To verify the otp
	 */
	@PostMapping(value = "/verifyOtp")
	public OtpResponse getOtp(@RequestBody OtpVerify request) {

		
		request.getOtp();
		request.getMobileNumber();
		
		OtpResponse res=new OtpResponse();
	
		
		return res;
	}

	@PostMapping(value = "/getDashboardDetails")
	public DashboardResponse getDashboardDetails(@RequestBody DashboardRequest request) {
		DashboardResponse res = new DashboardResponse();
		try {
			if (request == null) {
				res.setStatusCode("0001");
				res.setStatusMessage("Invalid Request");
				return res;
			}
			// System.out.println("Inside getDashboardDetails method : request :
			// "+request.toString());
			if (request.getDriverId() == null) {
				res.setStatusCode("0002");
				res.setStatusMessage("Driver Id can't be blank");
				return res;
			}
			Double totalEarning = 0d;
			Double completeAmount = 0d;
			Double inProgressAmount = 0d;
			List<DriverTripWeekInfoEntity> list = driverCurrentWkRepository
					.getDetailByDriverId(Integer.parseInt(request.getDriverId()));
			if (list.size() > 0) {
				for (DriverTripWeekInfoEntity en : list) {
					totalEarning = Double.sum(totalEarning, en.getTotalPayAmt());
					if (en.getPmtState().equalsIgnoreCase("approved")) {
						completeAmount = Double.sum(completeAmount, en.getTotalPayAmt());
					}
					if (en.getPmtState().equalsIgnoreCase("Unapproved")) {
						inProgressAmount = Double.sum(inProgressAmount, en.getTotalPayAmt());
					}
				}
			} else {
				res.setStatusCode("0003");
				res.setStatusMessage("No data available");
				return res;

			}
			System.out.println(list.toString());
			System.out.println("totalEarning : " + totalEarning);
			System.out.println("completeAmount : " + completeAmount);
			System.out.println("inProgressAmount : " + inProgressAmount);

			
			res.setStatusCode("0000");
			res.setStatusMessage("Success");
			res.setEarning(Double.parseDouble(String.format("%.2f", totalEarning)));
			res.setComplete(Double.parseDouble(String.format("%.2f", completeAmount)));
			res.setInProgress(Double.parseDouble(String.format("%.2f", inProgressAmount)));
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatusCode("1111");
			res.setStatusMessage("Fail");
			return res;
		}
		return res;
	}

	@PostMapping(value = "/getTripDetails")
	public TripResponse getTripDetails(@RequestBody TripRequest request) {
		System.out.println("inside getTripDetails");
		TripResponse res = new TripResponse();
		try {
			System.out.println("Inside getTripDetails method : request :" + request);
			if (request == null) {
				res.setStatusCode("0001");
				res.setStatusMessage("Invalid Request");
				return res;
			}
			// System.out.println("Inside getDetails method : request :
			// "+request.toString());
			if (request.getBillNo() == null && request.getDriverId() == null) {
				res.setStatusCode("0002");
				res.setStatusMessage("Frieght Id can't be blank");
				return res;
			}
			List<DriverTripMonthInfoEntity> list = driverTripMonthRepository
					.findByBillNoAndDriverId(request.getBillNo(), request.getDriverId());
			System.out.println("list size : " + list.size());
			if (list.size() > 0) {
				for (DriverTripMonthInfoEntity driver : list) {
					res.setDate(driver.getDeliveryDate());
					res.setFrieghtId(driver.getBillNo());
					res.setPaidStatus(driver.getPmtState());
					res.setSource(driver.getOrigCityState());
					res.setDestination(driver.getDestCityState());
				}
			} else {
				res.setStatusCode("0003");
				res.setStatusMessage("No record found for given detail");
				return res;
			}
			res.setStatusCode("0000");
			res.setStatusMessage("success");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatusCode("1111");
			res.setStatusMessage("Fail");
			return res;
		}
	}

	@PostMapping(value = "/getDetails")
	public DetailsResponse getDetails(@RequestBody DetailsRequest request) {
		DetailsResponse res = new DetailsResponse();
		try {
			System.out.println("Inside getDetails method : request :" + request);
			if (request == null) {
				res.setStatusCode("0001");
				res.setStatusMessage("Invalid Request");
				return res;
			}
			// System.out.println("Inside getDetails method : request :
			// "+request.toString());
			if (request.getFrieghtId() == null) {
				res.setStatusCode("0002");
				res.setStatusMessage("Frieght Id can't be blank");
				return res;
			}
			List<DriverTripMonthInfoEntity> list = driverTripMonthRepository
					.findByBillNo(String.valueOf(request.getFrieghtId()));
			System.out.println("list size : " + list.size());
			if (list.size() > 0) {
				for (DriverTripMonthInfoEntity driver : list) {
					res.setDate(driver.getDeliveryDate());
					res.setFrieghtId(driver.getBillNo());
					res.setPaidStatus(driver.getPmtState());
					res.setSource(driver.getOrigCityState());
					res.setDestination(driver.getDestCityState());

				}
			} else {
				res.setStatusCode("0003");
				res.setStatusMessage("No record found for given detail");
				return res;
			}
			res.setStatusCode("0000");
			res.setStatusMessage("success");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatusCode("1111");
			res.setStatusMessage("Fail");
			return res;
		}
	}
}
