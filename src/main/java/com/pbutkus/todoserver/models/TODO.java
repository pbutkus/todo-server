package com.pbutkus.todoserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "todo")
public class TODO {

    @Id
    private final UUID id = UUID.randomUUID();
    private String content;
    private final long created;
    private boolean completed;

    public TODO() {
        this.created = Instant.now().toEpochMilli();
        this.completed = false;
    }

    public TODO(String content) {
        this.content = content;
        this.created = Instant.now().toEpochMilli();
        this.completed = false;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public long getCreated() {
        return created;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
