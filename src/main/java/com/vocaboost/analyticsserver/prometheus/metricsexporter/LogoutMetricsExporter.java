package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;

public class LogoutMetricsExporter extends BaseMetricsExporter {

  public LogoutMetricsExporter(EventTypeEnum type) {
    super(type);
//    int count = eventService.findByTypeIncludeType(type.getName()).size();
    int count = 555;
    this.gauge.set(count);
  }
}
