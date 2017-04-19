package cz.vsb.ekf.lan0116.eventSystem.events.hero;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.location.Gateway;

/**
 * Triggered when player chose a location to travel to
 */
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

}
