package com.twilio.test.services.Impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.test.data.models.SMSModel;
import com.twilio.test.services.SMSService;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService {

    @Value("${app.account.sid}")
    private String ACCOUNT_SID;

    @Value("${app.auth.token}")
    private String AUTH_TOKEN;

    public void sendSms(SMSModel smsModel){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(smsModel.getToPhoneNumber()), // to
                        new PhoneNumber(smsModel.getFromPhoneNumber()), // from , this is number purchased in the console
                        smsModel.getMessage())
                .create();

        System.out.println(message.getSid());
    }
}
