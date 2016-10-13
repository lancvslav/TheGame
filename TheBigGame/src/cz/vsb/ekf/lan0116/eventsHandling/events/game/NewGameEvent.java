package cz.vsb.ekf.lan0116.eventsHandling.events.game;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;

public class NewGameEvent implements Event {

    @Override
    public EventSuperType getType() {
        return EventSuperType.GAME;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
