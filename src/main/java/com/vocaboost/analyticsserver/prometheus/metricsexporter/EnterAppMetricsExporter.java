package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;

public class EnterAppMetricsExporter extends BaseMetricsExporter {

  public EnterAppMetricsExporter(EventTypeEnum type) {
    super(type);
//    int count = eventService.findByTypeIncludeType(type.getName()).size();
    int count = 0;
    this.gauge.set(count);
  }

}
