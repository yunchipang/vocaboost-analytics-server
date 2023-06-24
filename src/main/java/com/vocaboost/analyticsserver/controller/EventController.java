package com.vocaboost.analyticsserver.controller;

import com.vocaboost.analyticsserver.model.Event;
import com.vocaboost.analyticsserver.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
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
  private EventService eventService;

  @GetMapping
  public List<Event> findAll() {
    return eventService.findAll();
  }

  @GetMapping(params="type")
  public List<Event> findByType(@RequestParam String type) { return eventService.findByType(type); }

  @GetMapping("/{id}")
  public Event findById(@PathVariable String id) {
    return eventService.findById(id);
  }

  @PostMapping
  public Event create(@RequestBody Event event) {
    return eventService.save(event);
  }

}
