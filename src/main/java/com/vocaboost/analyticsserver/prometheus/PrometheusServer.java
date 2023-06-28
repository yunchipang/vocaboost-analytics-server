package com.vocaboost.analyticsserver.prometheus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;

@RestController
@RequestMapping("/metrics")
public class PrometheusServer {

  public PrometheusServer() {

    DefaultExports.initialize();

    try {
      HTTPServer server = new HTTPServer(8081);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
