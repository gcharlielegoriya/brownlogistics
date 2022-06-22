package com.nihi.bl.driver.test;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Test {
    private static final String ACCOUNT_SID = "AC9ef9069f8f910f3140fa9cde02efcfa5";
    private static final String AUTH_TOKEN = "a7faf369356e372a86a913c836e396a3";
    private static final String FROM_NUMBER = "+19472253836";

    public static void main(String[] args) {

        try{
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            int min = 1000;
            int max = 9999;
            int number = (int) (Math.random() * (max - min + 1) + min);

            System.out.println(number);
            String msg = "Your OTP - " + number + "please verify you OTP in your Application by Brown Logistics";
            Message.creator(new PhoneNumber("+917978061053"),
                    new PhoneNumber(FROM_NUMBER), msg).create();
        }catch (Exception e){
            e.printStackTrace();
        }
//2705905160

    }
}
