package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginMetricsExporter extends BaseMetricsExporter {

  public LoginMetricsExporter(EventTypeEnum type) {
    super(type);
//    int count = eventService.findByTypeIncludeType(type.getName()).size();
    int count = 444;
    this.gauge.set(count);
  }
}
