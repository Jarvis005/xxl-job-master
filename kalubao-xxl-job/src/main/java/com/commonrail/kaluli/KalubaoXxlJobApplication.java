package com.commonrail.kaluli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class KalubaoXxlJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(KalubaoXxlJobApplication.class, args);
	}

}
