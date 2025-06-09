package com.gcp.agent25.cases.management.service.controller;

import com.gcp.agent25.cases.management.service.dto.CreateTicketRequest;
import com.gcp.agent25.cases.management.service.dto.RetrieveTicketResponse;
import com.gcp.agent25.cases.management.service.dto.RetrieveTicketsResponse;
import com.gcp.agent25.cases.management.service.dto.UpdateTicketRequest;
import com.gcp.agent25.cases.management.service.service.TicketService;
import com.gcp.agent25.common.core.dto.ResponsePayload;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.gcp.agent25.cases.management.service.constant.TicketRequestParams.*;
import static com.gcp.agent25.common.core.constant.ApiConstant.STATUS_SUCCESS;
import static com.gcp.agent25.common.core.constant.UriConstant.*;

@RestController
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping(API_VERSION_1 + TICKET_URL)
    public ResponsePayload<RetrieveTicketResponse> retrieveByTicketId(@Valid @NotBlank @RequestParam(TICKET_ID) String ticketId) {
        return ResponsePayload.<RetrieveTicketResponse>builder().status(STATUS_SUCCESS)
                .result(service.retrieveByTicketId(ticketId)).build();
    }

    @GetMapping(API_VERSION_1 + TICKETS_URL)
    public ResponsePayload<RetrieveTicketsResponse> retrieveTickets(
            @Valid @RequestParam(name = ASSIGNEE, required = false) String assignee,
            @RequestParam(name = STATUS, required = false) String status,
            @RequestParam(name = PRIORITY, required = false) String priority) {

        return ResponsePayload.<RetrieveTicketsResponse>builder().status(STATUS_SUCCESS)
                .result(service.retrieveTickets(assignee, status, priority)).build();
    }

    @PostMapping(API_VERSION_1 + TICKET_URL)
    public ResponsePayload<RetrieveTicketResponse> createTicket(@Valid @RequestBody CreateTicketRequest request) {
        return ResponsePayload.<RetrieveTicketResponse>builder().status(STATUS_SUCCESS)
                .result(service.createTicket(request)).build();
    }

    @PutMapping(API_VERSION_1 + TICKET_URL)
    public ResponsePayload<RetrieveTicketResponse> updateTicket(@Valid @RequestBody UpdateTicketRequest request) {
        return ResponsePayload.<RetrieveTicketResponse>builder().status(STATUS_SUCCESS)
                .result(service.updateTicket(request)).build();
    }
}
