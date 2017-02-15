package cz.vsb.ekf.lan0116.eventSystem.events.type;

import cz.vsb.ekf.lan0116.eventSystem.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;

public enum HeroType implements EventType {
    CONSUME,
    DROP,
    EQUIP,
    GET_READY,
    INTERACT,
    REST,
    SIGN_IN,
    TRADE,
    TRAVEL,
    PURCHASE,
    /**/;

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.HERO;
    }
}
