CREATE TABLE tickets_table (
    ticket_id VARCHAR(36) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description MEDIUMTEXT,
    assignee VARCHAR(100),
    priority VARCHAR(10),
    status VARCHAR(50) NOT NULL,
    created_time DATETIME(3) NOT NULL,
    updated_time DATETIME(3)
);