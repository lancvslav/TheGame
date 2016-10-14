package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;

public enum TravelFailure implements FailureCause {
    NO_GATEWAY,;

    @Override
    public EventType getEventType() {
        return HeroType.TRAVEL;
    }
}
