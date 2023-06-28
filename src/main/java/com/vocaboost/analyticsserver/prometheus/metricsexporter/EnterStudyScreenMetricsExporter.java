package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;

public class EnterStudyScreenMetricsExporter extends BaseMetricsExporter {

  public EnterStudyScreenMetricsExporter(EventTypeEnum type) {
    super(type);
//    int count = eventService.findByTypeIncludeType(type.getName()).size();
    int count = 222;
    this.gauge.set(count);
  }
}
