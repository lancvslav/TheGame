package cz.vsb.ekf.lan0116.eventSystem.serverEvents;

import java.util.LinkedList;
import java.util.Queue;

public class ResponseChannel {
    private final Queue<ServerEvent> responses = new LinkedList<>();

    public Queue<ServerEvent> getResponses() {
        return responses;
    }

    public void respond(ServerEvent serverEvent) {
        responses.add(serverEvent);
    }
}
