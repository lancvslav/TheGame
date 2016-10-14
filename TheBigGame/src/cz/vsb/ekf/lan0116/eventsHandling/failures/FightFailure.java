package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.CombatType;

public enum FightFailure implements FailureCause {
    DONT_KNOW_YET,;

    @Override
    public EventType getEventType() {
        return CombatType.ROUND;
    }
}

