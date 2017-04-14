package cz.vsb.ekf.lan0116.eventSystem.events.type;

import cz.vsb.ekf.lan0116.eventSystem.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;

/**
 * Event types related with hero's actions
 */
public enum HeroType implements EventType {
    CONSUME,
    DROP,
    EQUIP,
    GET_READY,
    INITIATE_DIALOGUE,
    INTERACT,
    REST,
    SIGN_IN,
    STOP_INTERACTING,
    STOP_TALKING,
    TALK,
    TRADE,
    TRAVEL,
    PURCHASE,
    /**/;

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.HERO;
    }
}
