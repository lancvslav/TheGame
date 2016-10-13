package cz.vsb.ekf.lan0116.eventsHandling.events.hero;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;
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
    public EventType getType() {
        return HeroType.TRAVEL;
    }

    @Override
    public EventSuperType getSuperType() {
        return null;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
