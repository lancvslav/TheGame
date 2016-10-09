package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;

public interface EventHandler<E extends Event, R extends Response> {

    R handleEvent(E event);

}
