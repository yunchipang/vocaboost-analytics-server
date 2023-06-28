package com.vocaboost.analyticsserver;

import com.vocaboost.analyticsserver.repository.EventRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = EventRepository.class)
public class AnalyticsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsServerApplication.class, args);
	}

}
