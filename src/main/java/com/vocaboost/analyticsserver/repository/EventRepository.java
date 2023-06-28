package com.vocaboost.analyticsserver.repository;

import com.vocaboost.analyticsserver.entity.EventEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<EventEntity, String> {

  @Query(value = "{}", fields = "{ 'type' : 1 }")
  List<EventEntity> findAllIncludeType();

  @Query(value = "{ 'type' : ?0 }")
  List<EventEntity> findByType(String type);

  @Query(value = "{ 'type' : ?0 }", fields = "{ 'type' : 1 }")
  List<EventEntity> findByTypeIncludeType(String type);

  @Query(value = "{ 'type': ?0, 'ts': { $gt: ?1 } }")
  List<EventEntity> findByTypeAndTime(String type, String ts);

  long count();

}
