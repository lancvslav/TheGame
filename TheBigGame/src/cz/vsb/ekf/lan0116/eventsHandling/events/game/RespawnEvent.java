package cz.vsb.ekf.lan0116.eventsHandling.events.game;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.GameType;

public class RespawnEvent implements Event {
    @Override
    public EventType getType() {
        return GameType.RESPAWN;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
