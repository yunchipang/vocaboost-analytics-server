package com.vocaboost.analyticsserver.repository;

import com.vocaboost.analyticsserver.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

  @Query(value = "{}", fields = "{ 'type' : 1 }")
  List<Event> findAllIncludeType();

  @Query(value = "{ 'type' : ?0 }")
  List<Event> findByType(String type);

  @Query(value = "{ 'type' : ?0 }", fields = "{ 'type' : 1 }")
  List<Event> findByTypeIncludeType(String type);

  @Query(value = "{ 'type': ?0, 'ts': { $gt: ?1 } }")
  List<Event> findByTypeAndTime(String type, String ts);

}
