package fr.esgi.log;

public abstract class Readable {

    private String body;

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
}
