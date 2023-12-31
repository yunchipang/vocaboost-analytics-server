package com.vocaboost.analyticsserver.prometheus.metricsexporter;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;

import io.prometheus.client.Gauge;

public abstract class BaseMetricsExporter {

  public final EventTypeEnum type;
  public final Gauge gauge;

  public BaseMetricsExporter(EventTypeEnum type) {
    this.type = type;
    this.gauge = Gauge.build()
            .name(String.format("vocaboost_%s_event_count_gauge", type.getName().toLowerCase()))
            .help(String.format("Count %s events.", type.getName()))
            .register();
  }

  public void increment() {
    this.gauge.inc();
  }

}
