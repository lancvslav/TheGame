package cz.vsb.ekf.lan0116.eventSystem.events.game;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.GameType;

public class RespawnEvent implements Event {
    @Override
    public EventType getType() {
        return GameType.RESPAWN;
    }

}
