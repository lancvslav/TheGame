package cz.vsb.ekf.lan0116.eventsHandling.events.game;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventSuperType;

public class NewGameEvent implements Event {

    @Override
    public EventSuperType getSuperType() {
        return EventSuperType.GAME_EVENT;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
