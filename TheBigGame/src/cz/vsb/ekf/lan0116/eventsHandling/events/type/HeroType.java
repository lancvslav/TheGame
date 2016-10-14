package cz.vsb.ekf.lan0116.eventsHandling.events.type;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public enum HeroType implements EventType {
    DROP,
    EQUIP,
    TRADE,
    TRAVEL,;

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.HERO;
    }
}