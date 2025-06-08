package com.gcp.agent25.cases.management.service.constant.model;

public class TicketsModelConstant {
    public static final String TICKETS_TABLE = "tickets_table";
    public static final String TICKET_ID = "ticket_id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String ASSIGNEE = "assignee";
    public static final String PRIORITY = "priority";
    public static final String STATUS = "status";
    public static final String CREATED_TIME = "created_time";
    public static final String UPDATED_TIME = "updated_time";

    public static class FieldLength {
        public static final int TICKET_ID = 36;
        public static final int ASSIGNEE = 100;
        public static final int PRIORITY = 10;
        public static final int STATUS = 50;
    }
}
