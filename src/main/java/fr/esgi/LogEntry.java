package fr.esgi;

import java.time.LocalDateTime;

public class LogEntry {

    private final LocalDateTime timestamp;
    private final String userId;
    private final String endpoint;
    private final String method;
    private final int status;
    private final long duration;

    public LogEntry(LocalDateTime timestamp,
                    String userId,
                    String endpoint,
                    String method,
                    int status,
                    long duration) {
        this.timestamp = timestamp;
        this.userId = userId;
        this.endpoint = endpoint;
        this.method = method;
        this.status = status;
        this.duration = duration;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public String getUserId() { return userId; }
    public String getEndpoint() { return endpoint; }
    public String getMethod() { return method; }
    public int getStatus() { return status; }
    public long getDuration() { return duration; }

    public boolean isError() {
        return status >= 400;
    }
}
