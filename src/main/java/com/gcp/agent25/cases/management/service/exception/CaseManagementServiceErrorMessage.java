package com.gcp.agent25.cases.management.service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static com.gcp.agent25.cases.management.service.constant.CaseManagementServiceErrorConstant.NOTIFICATION_NOT_FOUND_ERROR_CODE;
import static com.gcp.agent25.cases.management.service.constant.CaseManagementServiceErrorConstant.NOTIFICATION_NOT_FOUND_ERROR_DESC;


@Getter
public enum CaseManagementServiceErrorMessage {

    NOTIFICATION_NOT_FOUND(HttpStatus.NOT_FOUND, NOTIFICATION_NOT_FOUND_ERROR_CODE, NOTIFICATION_NOT_FOUND_ERROR_DESC);

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    // Constructor to initialize the enum constants
    CaseManagementServiceErrorMessage(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
