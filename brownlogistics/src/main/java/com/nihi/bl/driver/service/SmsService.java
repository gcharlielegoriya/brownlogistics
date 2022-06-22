package com.nihi.bl.driver.service;

import java.text.ParseException;


import org.springframework.stereotype.Component;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.messaging.Body;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;

@Component
public class SmsService {
	private final static String ACCOUNT_SID = "AC9ef9069f8f910f3140fa9cde02efcfa5";
	private final static String AUTH_TOKEN = "2cd788b2fe245b8706f3be9126c4d08a";
	private final static String FROM_NUMBER = "+19472253836";
	//private final static String FROM_NUMBER = "+12247729591";
	public String send(String toMobile) throws ParseException {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		int min = 1000;
		int max = 9999;
		int number = (int) (Math.random() * (max - min + 1) + min);

		String msg = "Your OTP - " + number + "please verify you OTP in your Application by Brown Logistics";

		Message message = Message.creator(
	               new com.twilio.type.PhoneNumber(toMobile),
	               new com.twilio.type.PhoneNumber(FROM_NUMBER),
	               msg
	               ).create();
		
		
		
		return msg;
	}
}
