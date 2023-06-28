package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;

public class LeaveStudyScreenMetricsExporter extends BaseMetricsExporter {

  public LeaveStudyScreenMetricsExporter(EventTypeEnum type) {
    super(type);
//    int count = eventService.findByTypeIncludeType(type.getName()).size();
    int count = 333;
    this.gauge.set(count);
  }
}
