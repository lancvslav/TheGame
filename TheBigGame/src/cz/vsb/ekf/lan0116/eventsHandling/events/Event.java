package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.eventsHandling.Response;

public interface Event<R extends Response> {

    EventType getType();

    EventSuperType getSuperType();

    Class<R> getResponseType();
}
