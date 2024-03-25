package aprilnotificationtwilio.service;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
    
    private  TwilioProperties twilioProperties;

    public TwilioInitializer(TwilioProperties twilioProperties){

        this.twilioProperties=twilioProperties;
        Twilio.init(twilioProperties.getAccountsId(), twilioProperties.getAuthToken());
        System.out.println("twilio intialized with account: "+ twilioProperties.getAccountsId());
    }

}
