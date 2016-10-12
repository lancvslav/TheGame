package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.world.Gateway;

public class TravelEvent implements Event {

    private final Gateway gateway;

    public TravelEvent(Gateway gateway) {
        this.gateway = gateway;
    }

    public Gateway getGateway() {
        return gateway;
    }

    @Override
    public EventSuperType getSuperType() {
        return EventSuperType.HERO_EVENT;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
