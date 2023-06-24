package com.vocaboost.analyticsserver.repository;

import com.vocaboost.analyticsserver.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {

  @Query(value = "{ 'type' : ?0 }")
  List<Event> findByType(String type);

  @Query(value = "{ 'type': ?0, 'ts': { $gt: ?1 } }")
  List<Event> findByTypeAndTime(String type, String ts);

}
