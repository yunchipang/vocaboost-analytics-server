package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;

public class EnterStudyScreenMetricsExporter extends BaseMetricsExporter {

  @Autowired
  EventService eventService;

  public EnterStudyScreenMetricsExporter(EventTypeEnum type) {
    super(type);
    int count = eventService.findByType(type.getName()).size();
    this.gauge.set(count);
  }
}
