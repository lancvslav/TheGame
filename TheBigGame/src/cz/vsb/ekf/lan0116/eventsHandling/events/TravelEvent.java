package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.world.Gateway;

public class TravelEvent implements EventTypeInterface {

    private final Gateway gateway;

    public TravelEvent(Gateway gateway) {
        this.gateway = gateway;
    }

    public Gateway getGateway() {
        return gateway;
    }

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.HERO_EVENT;
    }
}
