package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

public enum FightFailure implements FailureCause {
    DONT_KNOW_YET,;

    @Override
    public EventType getEventType() {
        return CombatType.ROUND;
    }
}

