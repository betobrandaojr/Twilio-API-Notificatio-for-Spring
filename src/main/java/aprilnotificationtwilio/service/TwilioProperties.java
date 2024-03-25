package aprilnotificationtwilio.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("Twilio")
public class TwilioProperties {
    
	private String accountSid;
	private String authToken;
	private String fromNumber;
	public String getAccountsId() {
		return accountSid;
	}
	public void setAccountsId(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFromNumber() {
		return fromNumber;
	}
	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}
	public TwilioProperties() {
		super();

	}
}
