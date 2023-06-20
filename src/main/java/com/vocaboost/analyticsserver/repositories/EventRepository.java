package com.vocaboost.analyticsserver.repositories;

import com.vocaboost.analyticsserver.models.Event;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
public interface EventRepository extends MongoRepository<Event, String> {

  // Fetch a list of events by type
  @Query(value="{type:'?0'}", fields="{'type' : 1, 'userId' : 1}")
  List<Event> findEventByType(String type);

  public long count();

}
