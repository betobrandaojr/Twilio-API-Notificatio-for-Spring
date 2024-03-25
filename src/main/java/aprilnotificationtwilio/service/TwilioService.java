package aprilnotificationtwilio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import aprilnotificationtwilio.TwilioRequest;

@Service
public class TwilioService {

    private TwilioProperties twilioProperties;

    @Autowired
    public TwilioService(TwilioProperties twilioproperties) {
        this.twilioProperties = twilioproperties;
    }

    // send message to number
    public String sendsms(TwilioRequest twilioRequest){

		Message message=Message.creator(new PhoneNumber("whatsapp:"+twilioRequest.getNumber()), new PhoneNumber("whatsapp:"+twilioProperties.getFromNumber()), twilioRequest.getMessage()).create();
        return message.getStatus().toString();
        
	}
    
}
