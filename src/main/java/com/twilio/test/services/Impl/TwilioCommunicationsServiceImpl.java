package com.twilio.test.services.Impl;

import com.twilio.test.data.models.SMSModel;
import com.twilio.test.repository.TwilioCommunicationsRepository;
import com.twilio.test.services.CacheService;
import com.twilio.test.services.SMSService;
import com.twilio.test.services.TwilioCommunicationsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Level;

@Log
@Service
public class TwilioCommunicationsServiceImpl implements TwilioCommunicationsService {

    @Autowired
    TwilioCommunicationsRepository twilioCommunicationsRepository;

    @Autowired
    CacheService cacheService;

    @Autowired
    SMSService smsService;

    @Override
    public SMSModel sendSms(SMSModel smsModel) {
        try{
            smsModel.setMessageSentSuccess(true);
            smsService.sendSms(smsModel);
        } catch (Exception ex){
            log.log(Level.SEVERE, "Error occurred while sending message!");
            smsModel.setMessageSentSuccess(false);
        }
        SMSModel smsModel1 = twilioCommunicationsRepository.save(smsModel);
        return smsModel1;
    }
}
