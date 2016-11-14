package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

public enum FightFailure implements FailureCause {
    ENEMY_DEAD,
    HERO_DEAD,;

    @Override
    public EventType getEventType() {
        return CombatType.ROUND;
    }
}

