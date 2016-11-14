package cz.vsb.ekf.lan0116.eventSystem.events.type;

import cz.vsb.ekf.lan0116.eventSystem.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;

public enum CombatType implements EventType {
    AMBUSH,
    DAMAGE_INFLICTION,
    ENGAGE,
    HEAL,
    PROCEED,
    ROUND,
    STAMINA_CONSUMPTION,
    STAMINA_REPLENISHMENT,;

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.COMBAT;
    }
}
