package cz.vsb.ekf.lan0116.eventSystem.events.hero.npc;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;

/**
 * Triggered when player chose to stand back from npc
 */
public class StopInteractingEvent implements Event {
    @Override
    public EventType getType() {
        return HeroType.STOP_INTERACTING;
    }
}
