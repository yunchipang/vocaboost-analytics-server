package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class EnterAppMetricsExporter extends BaseMetricsExporter {

  @Autowired
  EventRepository eventRepository;

  public EnterAppMetricsExporter(EventTypeEnum type) {
    super(type);
    int count = eventRepository.findByType(type.getName()).size();
    System.out.println("22222");
    this.gauge.set(count);
  }

}
