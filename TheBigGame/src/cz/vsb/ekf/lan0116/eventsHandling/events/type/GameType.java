package cz.vsb.ekf.lan0116.eventsHandling.events.type;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public enum GameType implements EventType {
    NEW_GAME,
    RESPAWN,;

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.GAME;
    }
}
