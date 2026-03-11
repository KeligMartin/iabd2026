package fr.esgi.log;


import java.time.LocalDateTime;

public class Log<T extends Readable> implements ILog {

    private T source;
    private CRITICITY criticity;
    private LocalDateTime timestamp;

    public Log(CRITICITY criticity, T source) {
        this.criticity = criticity;
        this.source = source;
        try {
            this.timestamp = this.getTimestamp();
        } catch (FutureTimestampException exception) {
            System.out.println(exception.getMessage());
            this.timestamp = LocalDateTime.now();
        }
    }

    public Log() {
    }

    public CRITICITY getCriticity() {
        return criticity;
    }

    public void setCriticity(CRITICITY criticity) {
        this.criticity = criticity;
    }

    public String getMessage() {
        return source.getBody();
    }

    public LocalDateTime getTimestamp() {
        if(source.getTimestamp().isAfter(LocalDateTime.now())) {
            throw new FutureTimestampException("Timestamp cannot be in the future");
        }
        return source.getTimestamp();
    }

    public Integer getStatus() {
        return source.getStatus();
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isError() {
        return true;
    }

    public void triggerException()  {
        if(this.criticity == CRITICITY.ERROR) {
            throw new BodyNotReadableException(String.format("Body is not readable: { %s }", this.source.getBody()));
        }
    }
}
