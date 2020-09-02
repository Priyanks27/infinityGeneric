package com.twilio.test.services;

import com.twilio.test.data.models.SMSModel;

public interface SMSService {

    public void sendSms(SMSModel smsModel);
}
