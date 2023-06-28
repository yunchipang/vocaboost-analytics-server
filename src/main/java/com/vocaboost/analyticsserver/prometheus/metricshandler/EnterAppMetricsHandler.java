package com.vocaboost.analyticsserver.prometheus.metricshandler;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;

public class EnterAppMetricsHandler extends BaseMetricsHandler {

  public EnterAppMetricsHandler(EventTypeEnum type) {
    super(type);
    int count = eventService.findByType(type.getName()).size();
    this.gauge.set(count);
  }

}
