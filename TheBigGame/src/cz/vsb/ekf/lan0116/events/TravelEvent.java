package cz.vsb.ekf.lan0116.events;

import cz.vsb.ekf.lan0116.world.Gateway;

public class TravelEvent extends Event {

    private final Gateway gateway;

    public TravelEvent(Gateway gateway) {
        super(EventType.TRAVEL);
        this.gateway = gateway;
    }

    public Gateway getGateway() {
        return gateway;
    }

}
