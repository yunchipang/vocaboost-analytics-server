package com.vocaboost.analyticsserver.prometheus;

import org.springframework.stereotype.Component;

import java.io.IOException;

import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;

@Component
public class PrometheusServer {

  public PrometheusServer() {

    DefaultExports.initialize();
    MetricsExporterSingleton.getInstance().initialize();

    try {
      HTTPServer server = new HTTPServer(8081);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
