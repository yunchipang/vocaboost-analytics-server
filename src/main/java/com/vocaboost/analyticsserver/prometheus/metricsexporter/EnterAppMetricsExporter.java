package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class EnterAppMetricsExporter extends BaseMetricsExporter {

//  @Autowired
//  EventRepository eventRepository;

  public EnterAppMetricsExporter(EventTypeEnum type) {
    super(type);
    System.out.println("---------- EnterAppMetricsExporter constructor called");
//    int count = eventRepository.findByTypeIncludeType(type.getName()).size();
    int count = 111;
    System.out.println("---------- EnterAppMetricsExporter constructed");
    this.gauge.set(count);
  }

}
