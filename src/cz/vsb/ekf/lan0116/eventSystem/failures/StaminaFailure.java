package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

public enum StaminaFailure implements FailureCause {
    NOT_ENOUGH_STAMINA,;

    @Override
    public EventType getEventType() {
        return CombatType.STAMINA_CONSUMPTION;
    }
}
