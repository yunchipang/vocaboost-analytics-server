package com.vocaboost.analyticsserver.prometheus.metricshandler;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.model.Event;
import com.vocaboost.analyticsserver.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;

public class LogoutMetricsHandler extends BaseMetricsHandler {

  @Autowired
  EventService eventService;
  public LogoutMetricsHandler(EventTypeEnum type) {
    super(type);
    int count = eventService.findByType(type.getName()).size();
    this.gauge.set(count);
  }
}
