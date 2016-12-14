package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

public enum CombatFailure implements FailureCause {
    ENEMY_DEAD,
    HERO_DEAD,
    NOT_ENOUGH_STAMINA,
    TARGET_DEAD,
    UNKNOWN,
    YOU_DIED,;

    @Override
    public EventType getEventType() {
        return CombatType.ATTACK_MOVE;
    }
}

