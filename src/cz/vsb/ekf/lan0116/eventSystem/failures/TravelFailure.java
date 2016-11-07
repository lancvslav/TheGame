package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;

public enum TravelFailure implements FailureCause {
    NO_GATEWAY,;

    @Override
    public EventType getEventType() {
        return HeroType.TRAVEL;
    }
}
