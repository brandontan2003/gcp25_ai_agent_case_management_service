package com.gcp.agent25.cases.management.service.enums;

import lombok.Getter;

@Getter
public enum TicketStatusEnum {
    CRITICAL("CRITICAL"),
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    private final String value;

    TicketStatusEnum(String value) {
        this.value = value;
    }
}
