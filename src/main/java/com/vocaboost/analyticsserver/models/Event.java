package com.vocaboost.analyticsserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Event {

  private String type;
  private String userId;
  private String loginMethod;
  private DeviceInfo deviceInfo;
  private String ts;

  public Event(String type, String userId, String loginMethod, DeviceInfo deviceInfo, String ts) {
    this.type = type;
    this.userId = userId;
    this.loginMethod = loginMethod;
    this.deviceInfo = deviceInfo;
    this.ts = ts;
  }

  // Inner class for deviceInfo
  public static class DeviceInfo {
    private String uniqueId;
    private String manufacturer;
    private String appVersion;
    private String systemVersion;
    private String deviceId;
    private boolean isTablet;

    public DeviceInfo(String uniqueId, String manufacturer, String appVersion, String systemVersion, String deviceId, boolean isTablet) {
      this.uniqueId = uniqueId;
      this.manufacturer = manufacturer;
      this.appVersion = appVersion;
      this.systemVersion = systemVersion;
      this.deviceId = deviceId;
      this.isTablet = isTablet;
    }
  }

}
