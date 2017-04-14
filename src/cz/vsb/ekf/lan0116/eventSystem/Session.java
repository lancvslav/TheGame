package cz.vsb.ekf.lan0116.eventSystem;

import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventPublisher;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;

import java.util.Queue;

public class Session {

    private final EventPublisher eventPublisher;
    private final ResponseChannel responseChannel;

    public Session(EventPublisher eventPublisher, ResponseChannel responseChannel) {
        this.eventPublisher = eventPublisher;
        this.responseChannel = responseChannel;
    }

    /**
     * Fires entity implementing Event interface to be further processed by devoted Event subscriber
     * @param event to be processed
     * @return Response by event subscriber describing outcome of that processed event
     */
    public Response fireEvent(Event event) {
        return eventPublisher.getResponse(event);
    }

    public Queue<ServerEvent> getResponses() {
        return responseChannel.getResponses();
    }

    public ResponseChannel getResponseChannel() {
        return responseChannel;
    }
}
