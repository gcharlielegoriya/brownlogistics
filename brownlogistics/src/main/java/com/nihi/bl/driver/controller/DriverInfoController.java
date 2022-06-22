package com.nihi.bl.driver.controller;

import org.springframework.stereotype.Controller;

@Controller
public class DriverInfoController {
	/*
	 * 
	 * @Autowired(required = true) private DriverDetailService driverService;
	 * 
	 * 
	 * this method is used to get the data of All Driver
	 * 
	 * @RequestMapping(value = "/driverinfo", method = RequestMethod.GET) public
	 * String getDriverInfo(Model model) { System.out.println("Controller called");
	 * List<DriverDetailsModel> driverList = driverService.getDriverDetails();
	 * 
	 * model.addAttribute("driverinfo", driverList);
	 * 
	 * return "View Name"; }
	 * 
	 * 
	 * 
	 * 
	 * this method is used to get the data of Driver by using the mobile number
	 * 
	 * @RequestMapping(value = "drivermob", method = RequestMethod.GET) public
	 * String getDriverInfoMobile(@RequestParam("mobileNumber") String mobileNumber,
	 * Model model) { DriverDetailsModel driverDetails =
	 * driverService.getDriverDetails(mobileNumber);
	 * System.out.println(driverDetails); model.addAttribute("driverinfo",
	 * driverDetails);
	 * 
	 * return "View_Name"; }
	 * 
	 * 
	 * method for sending the otp
	 * 
	 * @RequestMapping(value = "driverAuth", method = RequestMethod.GET) public
	 * ResponseEntity<String> getDriverAuth(@RequestParam("mobileNum") String
	 * mobileNum, Model model) {
	 * 
	 * @SuppressWarnings("unused") String msg; System.out.println(mobileNum); try {
	 * 
	 * SmsService sms = new SmsService(); System.out.println("hello"); msg =
	 * sms.send(mobileNum);
	 * 
	 * // model.addAttribute(msg, msg);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return new ResponseEntity<String>("", HttpStatus.OK); }
	 * 
	 * 
	 * This request for showing records weekly basis...
	 * 
	 * @RequestMapping(value = "weekInfo", method = RequestMethod.GET) public String
	 * getWeeklyDriverAmtDetails(HttpRequest req) { driverService.getWeeklyInfo();
	 * return null; }
	 * 
	 * 
	 * This request for showing records of monthly basis...
	 * 
	 * @RequestMapping(value = "monthInfo", method = RequestMethod.GET) public
	 * String getMonthlyDriverAmtDetails(@RequestParam("startDate") Date startDate,
	 * 
	 * @RequestParam("endDate") Date endDate, Model model) {
	 * List<DriverTripMonthModel> driverTripPaidModel =
	 * driverService.getMonthlyRecords(startDate, endDate); if
	 * (!driverTripPaidModel.isEmpty()) { model.addAttribute("viewTripPaid",
	 * driverTripPaidModel); return "viewName"; } else {
	 * //model.addAttribute("empty", AppConstants.Empty); return "View_Name"; } }
	 * 
	 */}
