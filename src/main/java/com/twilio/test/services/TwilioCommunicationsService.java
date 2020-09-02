package com.twilio.test.services;

import com.twilio.test.data.models.SMSModel;

public interface TwilioCommunicationsService {

    SMSModel sendSms(SMSModel SMSModel);

}
