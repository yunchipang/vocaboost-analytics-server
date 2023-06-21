package com.vocaboost.analyticsserver.repository;

import com.vocaboost.analyticsserver.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {}
