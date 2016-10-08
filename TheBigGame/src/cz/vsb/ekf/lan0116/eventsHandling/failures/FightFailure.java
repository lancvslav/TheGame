package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public enum FightFailure implements FailureCause {
    DONT_KNOW_YET,;

    @Override
    public EventType getEventType() {
        return EventType.FIGHT_ROUND_EVENT;
    }
}

