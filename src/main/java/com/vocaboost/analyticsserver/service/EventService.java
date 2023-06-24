package com.vocaboost.analyticsserver.service;

import com.vocaboost.analyticsserver.exception.EntityNotFoundException;
import com.vocaboost.analyticsserver.model.Event;
import com.vocaboost.analyticsserver.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class EventService {

  @Autowired
  public EventRepository eventRepository;

  public List<Event> findAll() {
    return eventRepository.findAll();
  }

  public List<Event> findByType(String type) { return eventRepository.findByType(type); }

  public List<Event> findByTypeAndTime(String type, int hours) {
    LocalDateTime currentDatetime = LocalDateTime.now();
    LocalDateTime lowerBoundDatetime = currentDatetime.minus(hours, ChronoUnit.HOURS);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    String lowerBoundDatetimeString = lowerBoundDatetime.format(formatter);
    return eventRepository.findByTypeAndTime(type, lowerBoundDatetimeString);
  }

  public Event findById(String id) {
    return eventRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Event save(Event event) {
    return eventRepository.save(event);
  }

}
