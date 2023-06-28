package com.vocaboost.analyticsserver.enumeration;

public enum EventTypeEnum {

    ENTER_APP("ENTER_APP"),
    LOGIN("LOGIN"),
    LOGOUT("LOGOUT"),
    ENTER_STUDY_SCREEN("ENTER_STUDY_SCREEN"),
    LEAVE_STUDY_SCREEN("LEAVE_STUDY_SCREEN"),
    UNKNOWN("UNKNOWN");

    private final String name;

    EventTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEnterApp() {
        return this == ENTER_APP;
    }

    public boolean isLogin() {
        return this == LOGIN;
    }

    public boolean isLogout() {
        return this == LOGOUT;
    }

    public boolean isEnterStudyScreen() {
        return this == ENTER_STUDY_SCREEN;
    }

    public boolean isLeaveStudyScreen() {
        return this == LEAVE_STUDY_SCREEN;
    }

    public boolean isAuthEvents() {
        return isLogin() || isLogout();
    }

    public boolean isUnknown() {
        return this == UNKNOWN;
    }
}