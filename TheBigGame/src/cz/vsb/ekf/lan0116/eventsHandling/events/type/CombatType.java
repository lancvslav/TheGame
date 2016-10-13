package cz.vsb.ekf.lan0116.eventsHandling.events.type;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public enum CombatType implements EventType {
    INFLICT_DAMAGE,
    ROUND,;

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.COMBAT;
    }
}
