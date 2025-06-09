package com.gcp.agent25.cases.management.service.service;

import com.gcp.agent25.cases.management.service.dto.CreateTicketRequest;
import com.gcp.agent25.cases.management.service.dto.RetrieveTicketResponse;
import com.gcp.agent25.cases.management.service.dto.RetrieveTicketsResponse;
import com.gcp.agent25.cases.management.service.dto.UpdateTicketRequest;
import com.gcp.agent25.cases.management.service.exception.CaseManagementServiceException;
import com.gcp.agent25.cases.management.service.model.Ticket;
import com.gcp.agent25.cases.management.service.repository.TicketRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.gcp.agent25.cases.management.service.exception.CaseManagementServiceErrorMessage.TICKET_NOT_FOUND;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public RetrieveTicketResponse updateTicket(UpdateTicketRequest request) {
        Ticket ticket = repository.findByTicketId(request.getTicketId())
                .orElseThrow(() -> new CaseManagementServiceException(TICKET_NOT_FOUND));

        if (StringUtils.isNotBlank(request.getAssignee())) {
            ticket.setAssignee(request.getAssignee());
        }

        if (StringUtils.isNotBlank(request.getStatus().getValue())) {
            ticket.setStatus(request.getStatus().getValue());
        }

        if (StringUtils.isNotBlank(request.getPriority().getValue())) {
            ticket.setPriority(request.getPriority().getValue());
        }
        return buildRetrieveTicketResponse(repository.save(ticket));
    }

    public RetrieveTicketResponse createTicket(CreateTicketRequest request) {
        return buildRetrieveTicketResponse(saveTicket(request));
    }

    private Ticket saveTicket(CreateTicketRequest request) {
        Ticket ticket = new Ticket();
        ticket.setDescription(request.getDescription());
        ticket.setTitle(request.getTitle());
        ticket.setAssignee(request.getAssignee());
        ticket.setStatus(request.getStatus().getValue());
        ticket.setPriority(request.getPriority().getValue());
        return repository.save(ticket);
    }

    public RetrieveTicketResponse retrieveByTicketId(String ticketId) {
        Optional<Ticket> optionalTicket = repository.findByTicketId(ticketId);
        return optionalTicket.map(this::buildRetrieveTicketResponse).orElseGet(() -> RetrieveTicketResponse.builder().build());
    }

    public RetrieveTicketsResponse retrieveTickets(String assignee, String status, String priority) {
        List<Ticket> ticketList = repository.findAll().stream()
                .filter(ticket -> assignee == null || assignee.equals(ticket.getAssignee()))
                .filter(ticket -> status == null || status.equalsIgnoreCase(ticket.getStatus()))
                .filter(ticket -> priority == null || priority.equalsIgnoreCase(ticket.getPriority()))
                .toList();
        if (ticketList.isEmpty()) {
            return RetrieveTicketsResponse.builder().tickets(Collections.emptyList()).build();
        }
        return RetrieveTicketsResponse.builder().tickets(ticketList.stream().map(this::buildRetrieveTicketResponse).toList()).build();
    }

    private RetrieveTicketResponse buildRetrieveTicketResponse(Ticket ticket) {
        RetrieveTicketResponse response = new RetrieveTicketResponse();
        response.setTicketId(ticket.getTicketId());
        response.setDescription(ticket.getDescription());
        response.setTitle(ticket.getTitle());
        response.setAssignee(ticket.getAssignee());
        response.setStatus(ticket.getStatus());
        response.setPriority(ticket.getPriority());
        return response;
    }
}
