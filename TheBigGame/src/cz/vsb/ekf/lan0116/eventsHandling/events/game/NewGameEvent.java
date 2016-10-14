package cz.vsb.ekf.lan0116.eventsHandling.events.game;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.GameType;

public class NewGameEvent implements Event {

    @Override
    public EventType getType() {
        return GameType.NEW_GAME;
    }

}
