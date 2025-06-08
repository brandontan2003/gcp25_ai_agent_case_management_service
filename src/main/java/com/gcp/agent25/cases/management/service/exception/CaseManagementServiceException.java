package com.gcp.agent25.cases.management.service.exception;

import lombok.Getter;

@Getter
public class CaseManagementServiceException extends RuntimeException {

    private final CaseManagementServiceErrorMessage errorMessage;

    public CaseManagementServiceException(CaseManagementServiceErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
        this.errorMessage = errorMessage;
    }
}
