package com.vocaboost.analyticsserver;

import com.vocaboost.analyticsserver.repository.EventRepository;
import com.vocaboost.analyticsserver.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AnalyticsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsServerApplication.class, args);
	}

}
