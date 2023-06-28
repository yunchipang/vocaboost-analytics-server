package com.vocaboost.analyticsserver.controller;

import com.vocaboost.analyticsserver.model.Event;
import com.vocaboost.analyticsserver.prometheus.MetricsHandler;
import com.vocaboost.analyticsserver.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/event-tracking")
public class EventController {

  @Autowired
  public EventService eventService;

  public MetricsHandler metricsHandler = new MetricsHandler();

  @GetMapping
  public List<Event> findAll() {
    return eventService.findAll();
  }

  @GetMapping(params="type")
  public List<Event> findByType(@RequestParam String type) { return eventService.findByType(type); }

  @GetMapping(params={"type", "hours"})
  public List<Event> findByTypeAndTime(@RequestParam String type, @RequestParam int hours) {
    return eventService.findByTypeAndTime(type, hours);
  }

  @GetMapping("/{id}")
  public Event findById(@PathVariable String id) {
    return eventService.findById(id);
  }

  @PostMapping
  public ResponseEntity<String> create(@RequestBody Event event) {
    try {
      eventService.save(event);
    } catch (Exception e) {
      return new ResponseEntity<>("creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    metricsHandler.updateMetrics(event.getType());
    return new ResponseEntity<>("created", HttpStatus.CREATED);
  }

}
