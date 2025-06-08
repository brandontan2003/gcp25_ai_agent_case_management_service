package com.gcp.agent25.cases.management.service.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import static com.gcp.agent25.cases.management.service.constant.model.TicketsModelConstant.*;
import static com.gcp.agent25.common.core.constant.JpaConstant.MEDIUM_TEXT;


@Data
@Entity
@Table(name = TICKETS_TABLE)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = TICKET_ID, length = FieldLength.TICKET_ID, nullable = false)
    private String ticketId;

    @Column(name = TITLE, nullable = false)
    private String title;

    @Lob
    @Column(name = DESCRIPTION, columnDefinition = MEDIUM_TEXT, nullable = false)
    private String description;

    @Column(name = ASSIGNEE, length = FieldLength.ASSIGNEE)
    private String assignee;

    @Column(name = PRIORITY, length = FieldLength.PRIORITY)
    private String priority;

    @Column(name = STATUS, length = FieldLength.STATUS)
    private String status;

    @CreationTimestamp
    @Column(name = CREATED_TIME, nullable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(name = UPDATED_TIME)
    private LocalDateTime updatedTime;
}
