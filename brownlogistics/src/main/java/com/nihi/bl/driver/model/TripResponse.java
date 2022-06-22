package com.nihi.bl.driver.model;

import java.util.Date;

import lombok.Data;

@Data
public class TripResponse {
	private String BillNo;
	
	private Date date;
	private String frieghtId;
	private String paidStatus;
	private String source;
	private String destination;
	private String payDescription;
	private Long totalPayAmt;
	
	private String statusCode;
	private String statusMessage;
	
	
	
	/*
	 * Date: Delivery Date
Frieght ID: Bill Number
Paid/not Paid Status - Payment status =X (paid) - else Not Paid
Source - Orig_city_state

Destination - Dest_city_state

Accumulated Payment TOTAL_PAY_AMT by PAY_DESCRIPTION
Payment - Accumulated amount by Pay-Description


182.63 - Paid by Percentage of Gross
50 - Paid by Pickups/Drops

45 - FS_PAY (FUEL SCHEDULE FOR BROWN STANDARD PAY)
	 */
}
