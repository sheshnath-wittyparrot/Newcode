package com.in28minutes.springboot.learnspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*currency-service.url=
currency-service.username=
currency-service.key=*/
@ConfigurationProperties(prefix ="currency-service")
@Component

public class CurrencyServiceConfiguration {
	private String url;
	private String username;
	private String key;
	public String getUrl() {
		return url;
	}
	public String getUsername() {
		return username;
	}
	public String getKey() {
		return key;
	}
	

}
