package fr.esgi.log;

import java.time.LocalDateTime;

public abstract class Readable {

    private String body;
    private LocalDateTime timestamp = LocalDateTime.now();

    public Readable(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getStatus() {
        return 500;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void greet() {
        System.out.println("Hello World! ");
    }
}
