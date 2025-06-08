package com.gcp.agent25.cases.management.service.exception;

import com.gcp.agent25.common.core.dto.ResponsePayload;
import com.gcp.agent25.common.core.dto.error.ErrorPayload;
import com.gcp.agent25.common.core.dto.error.ErrorsPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static com.gcp.agent25.common.core.constant.ApiConstant.STATUS_ERROR;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CaseManagementServiceException.class)
    public ResponseEntity<ResponsePayload<ErrorsPayload>> supportingServiceExceptionHandler(CaseManagementServiceException ex) {
        CaseManagementServiceErrorMessage err = ex.getErrorMessage();
        return ResponseEntity.status(err.getHttpStatus()).body(ResponsePayload.<ErrorsPayload>builder()
                .status(STATUS_ERROR).result(ErrorsPayload.builder().errors(List.of(getError(err))).build()).build());
    }

    private static ErrorPayload getError(CaseManagementServiceErrorMessage err) {
        return ErrorPayload.builder().errorCode(err.getErrorCode()).errorMessage(err.getErrorMessage()).build();
    }

}
