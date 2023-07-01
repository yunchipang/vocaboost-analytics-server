package com.vocaboost.analyticsserver.prometheus;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.prometheus.metricsexporter.BaseMetricsExporter;
import com.vocaboost.analyticsserver.prometheus.metricsexporter.EnterAppMetricsExporter;
import com.vocaboost.analyticsserver.prometheus.metricsexporter.EnterStudyScreenMetricsExporter;
import com.vocaboost.analyticsserver.prometheus.metricsexporter.LeaveStudyScreenMetricsExporter;
import com.vocaboost.analyticsserver.prometheus.metricsexporter.LoginMetricsExporter;
import com.vocaboost.analyticsserver.prometheus.metricsexporter.LogoutMetricsExporter;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MetricsExporterSingleton {

  private static final MetricsExporterSingleton instance = new MetricsExporterSingleton();
  public Map<EventTypeEnum, BaseMetricsExporter> handlersMap;

  private MetricsExporterSingleton() {
    this.handlersMap = new HashMap<>();
  }

  public static MetricsExporterSingleton getInstance() {
    return instance;
  }

  public void initialize() {
    handlersMap.put(EventTypeEnum.ENTER_APP, new EnterAppMetricsExporter(EventTypeEnum.ENTER_APP));
    handlersMap.put(EventTypeEnum.LOGIN, new LoginMetricsExporter(EventTypeEnum.LOGIN));
    handlersMap.put(EventTypeEnum.LOGOUT, new LogoutMetricsExporter(EventTypeEnum.LOGOUT));
    handlersMap.put(EventTypeEnum.ENTER_STUDY_SCREEN, new EnterStudyScreenMetricsExporter(EventTypeEnum.ENTER_STUDY_SCREEN));
    handlersMap.put(EventTypeEnum.LEAVE_STUDY_SCREEN, new LeaveStudyScreenMetricsExporter(EventTypeEnum.LEAVE_STUDY_SCREEN));
  }

  public void updateMetrics(String type) {
    EventTypeEnum eventType = EventTypeEnum.valueOf(type);
    switch (eventType) {
      case ENTER_APP:
        handlersMap.get(EventTypeEnum.ENTER_APP).increment();
        break;
      case LOGIN:
        handlersMap.get(EventTypeEnum.LOGIN).increment();
        break;
      case LOGOUT:
        handlersMap.get(EventTypeEnum.LOGOUT).increment();
        break;
      case ENTER_STUDY_SCREEN:
        handlersMap.get(EventTypeEnum.ENTER_STUDY_SCREEN).increment();
        break;
      case LEAVE_STUDY_SCREEN:
        handlersMap.get(EventTypeEnum.LEAVE_STUDY_SCREEN).increment();
        break;
      default:
        // Handle unsupported event type
        break;
    }
  }

}
