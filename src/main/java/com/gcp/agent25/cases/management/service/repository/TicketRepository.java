package com.gcp.agent25.cases.management.service.repository;

import com.gcp.agent25.cases.management.service.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

}