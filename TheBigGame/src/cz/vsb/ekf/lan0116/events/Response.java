package cz.vsb.ekf.lan0116.events;

public class Response {

    private boolean success;
    public static final Response SUCCESS = new Response(true);

    public Response(boolean success) {
        this.success = success;
    }

}
