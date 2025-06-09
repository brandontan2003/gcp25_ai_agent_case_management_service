package com.gcp.agent25.cases.management.service.service;

import com.gcp.agent25.cases.management.service.dto.RetrieveTicketResponse;
import com.gcp.agent25.cases.management.service.dto.RetrieveTicketsResponse;
import com.gcp.agent25.cases.management.service.model.Ticket;
import com.gcp.agent25.cases.management.service.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

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
}
