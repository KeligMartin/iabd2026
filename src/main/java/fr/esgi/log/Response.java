package fr.esgi.log;

public class Response extends Readable {

    private Integer status;

    public Response(String body, int status) {
        super(body);
        this.status = status;
    }

    @Override
    public Integer getStatus() {
        return status;
    }
}
