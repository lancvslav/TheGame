package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

public enum CombatFailure implements FailureCause {
    ENEMY_DEAD,
    TARGET_DEAD,
    HERO_DEAD,
    UNKNOWN,;

    @Override
    public EventType getEventType() {
        return CombatType.ROUND;
    }
}

