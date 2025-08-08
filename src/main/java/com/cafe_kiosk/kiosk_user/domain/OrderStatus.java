package com.cafe_kiosk.kiosk_user.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    WAITING("waiting"),
    COMPLETE("complete"),
    CANCELLED("cancelled");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    // 제이슨 파싱시 오류 방지
    @JsonValue
    public String getValue() {
        return value;
    }

    public static OrderStatus from(String value) {
        for (OrderStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + value);
    }
}
