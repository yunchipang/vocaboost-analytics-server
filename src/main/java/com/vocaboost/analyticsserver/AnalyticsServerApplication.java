package com.vocaboost.analyticsserver;

import com.vocaboost.analyticsserver.models.Event;
import com.vocaboost.analyticsserver.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AnalyticsServerApplication implements CommandLineRunner {

	@Autowired
	EventRepository eventRepository;

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Perform database operations here

		// 1. Create event records
		System.out.println("---------- Start creating events ----------");
		Event.DeviceInfo deviceInfo = new Event.DeviceInfo("75535859-91CD-4D6E-AA84-3CFF91D32C0F", "Apple", "1.1.0.1.1.1", "16.2", "iPhone15,3", false);
		eventRepository.save(new Event("ENTER_APP", "55cb0767-a286-46ea-8d8a-49f47e98473a", "1", deviceInfo, "2023-06-20T04:59:21.283Z"));
		eventRepository.save(new Event("ENTER_STUDY_SCREEN", "55cb0767-a286-46ea-8d8a-49f47e98473a", "1", deviceInfo,"2023-06-20T04:59:34.857Z"));
		eventRepository.save(new Event("ENTER_STUDY_SCREEN", "55cb0767-a286-46ea-8d8a-49f47e98473a", "1", deviceInfo,"2023-06-20T04:59:43.999Z"));
		eventRepository.save(new Event("LEAVE_STUDY_SCREEN", "55cb0767-a286-46ea-8d8a-49f47e98473a", "1", deviceInfo,"2023-06-20T04:59:43.999Z"));
		System.out.println("---------- Finish creating events ----------");

		// 2. Fetch events by type (enter study screen)
		System.out.println("---------- Fetching events bt type ----------");
		for (Event event : eventRepository.findEventByType("ENTER_STUDY_SCREEN")) {
			System.out.println(event);
		}

	}

}
