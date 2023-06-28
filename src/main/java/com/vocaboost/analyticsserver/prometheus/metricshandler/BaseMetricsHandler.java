package com.vocaboost.analyticsserver.prometheus.metricshandler;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;

import io.prometheus.client.Gauge;

public abstract class BaseMetricsHandler {

  public final EventTypeEnum type;
  public final Gauge gauge;
  @Autowired
  public EventService eventService;

  public BaseMetricsHandler(EventTypeEnum type) {
    this.type = type;
    this.gauge = Gauge.build()
            .name(String.format("vocaboost_%s_event_count_gauge", type.getName().toLowerCase()))
            .help(String.format("Count %s events.", type.getName()))
            .register();
    this.eventService = new EventService();
  }

  public void increment() {
    this.gauge.inc();
  }

}
