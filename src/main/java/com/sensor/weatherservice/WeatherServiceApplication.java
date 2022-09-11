package com.sensor.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

//	@PostConstruct
//	private void setTimeZone() {
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//	}

}
