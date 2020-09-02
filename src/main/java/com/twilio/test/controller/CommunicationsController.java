package com.twilio.test.controller;

import com.twilio.test.data.models.SMSModel;
import com.twilio.test.services.TwilioCommunicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommunicationsController {

    @Autowired
    TwilioCommunicationsService twilioCommunicationsService;

    @PostMapping("/sms")
    public SMSModel sendSms(@RequestBody SMSModel smsModel) {
        return twilioCommunicationsService.sendSms(smsModel);
    }
}
