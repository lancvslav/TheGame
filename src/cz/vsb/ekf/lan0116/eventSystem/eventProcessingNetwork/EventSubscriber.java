package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;

public interface EventSubscriber {

    Response handleEvent(Event event);

}
