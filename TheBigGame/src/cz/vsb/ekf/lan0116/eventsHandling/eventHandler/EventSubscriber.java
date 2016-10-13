package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;

public interface EventSubscriber {

    <R extends Response> R handleEvent(Event<R> event);

}
