package com.vocaboost.analyticsserver.prometheus;

import com.vocaboost.analyticsserver.enumeration.EventTypeEnum;
import com.vocaboost.analyticsserver.prometheus.metricshandler.BaseMetricsHandler;
import com.vocaboost.analyticsserver.prometheus.metricshandler.EnterAppMetricsHandler;
import com.vocaboost.analyticsserver.prometheus.metricshandler.EnterStudyScreenMetricsHandler;
import com.vocaboost.analyticsserver.prometheus.metricshandler.LeaveStudyScreenMetricsHandler;
import com.vocaboost.analyticsserver.prometheus.metricshandler.LoginMetricsHandler;
import com.vocaboost.analyticsserver.prometheus.metricshandler.LogoutMetricsHandler;

import java.util.HashMap;
import java.util.Map;

public class MetricsHandler {

  public Map<EventTypeEnum, BaseMetricsHandler> handlersMap;

  public MetricsHandler() {
    this.handlersMap = new HashMap<>();
    handlersMap.put(EventTypeEnum.ENTER_APP, new EnterAppMetricsHandler(EventTypeEnum.ENTER_APP));
    handlersMap.put(EventTypeEnum.LOGIN, new LoginMetricsHandler(EventTypeEnum.LOGIN));
    handlersMap.put(EventTypeEnum.LOGOUT, new LogoutMetricsHandler(EventTypeEnum.LOGOUT));
    handlersMap.put(EventTypeEnum.ENTER_STUDY_SCREEN, new EnterStudyScreenMetricsHandler(EventTypeEnum.ENTER_STUDY_SCREEN));
    handlersMap.put(EventTypeEnum.LEAVE_STUDY_SCREEN, new LeaveStudyScreenMetricsHandler(EventTypeEnum.LEAVE_STUDY_SCREEN));
    System.out.println("------- MetricsHandler constructor completed -------");
    System.out.println("------- handlersMap: " + handlersMap.toString());
  }

  public void updateMetrics(String type) {
    EventTypeEnum eventType = EventTypeEnum.valueOf(type);
    switch (eventType) {
      case ENTER_APP:
        EnterAppMetricsHandler enterAppMetricsHandler = new EnterAppMetricsHandler(eventType);
        enterAppMetricsHandler.increment();
        break;
      case LOGIN:
        LoginMetricsHandler loginMetricHandler = new LoginMetricsHandler(eventType);
        loginMetricHandler.increment();
        break;
      case LOGOUT:
        LogoutMetricsHandler logoutMetricsHandler = new LogoutMetricsHandler(eventType);
        logoutMetricsHandler.increment();
        break;
      case ENTER_STUDY_SCREEN:
        EnterStudyScreenMetricsHandler enterStudyScreenMetricsHandler = new EnterStudyScreenMetricsHandler(eventType);
        enterStudyScreenMetricsHandler.increment();
        break;
      case LEAVE_STUDY_SCREEN:
        LeaveStudyScreenMetricsHandler leaveStudyScreenMetricsHandler = new LeaveStudyScreenMetricsHandler(eventType);
        leaveStudyScreenMetricsHandler.increment();
        break;
      default:
        // Handle unsupported event type
        break;
    }
  }

}
