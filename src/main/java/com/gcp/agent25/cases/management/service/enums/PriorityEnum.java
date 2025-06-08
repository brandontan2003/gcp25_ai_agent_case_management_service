package com.gcp.agent25.cases.management.service.enums;

import lombok.Getter;

@Getter
public enum PriorityEnum {
    OPEN("OPEN"),
    IN_PROGRESS("IN_PROGRESS"),
    RESOLVED("RESOLVED");

    private final String value;

    PriorityEnum(String value) {
        this.value = value;
    }
}
