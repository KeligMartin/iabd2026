package fr.esgi.log;


import java.time.LocalDateTime;

public class Log implements ILog {

    private CRITICITY criticity;
    private String message;
    private LocalDateTime timestamp;
    private Integer status;

    public Log(CRITICITY criticity, String message, LocalDateTime timestamp, Integer status) {
        this.criticity = criticity;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
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
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isError() {
        return true;
    }
}
