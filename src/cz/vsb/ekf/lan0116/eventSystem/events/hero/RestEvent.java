package cz.vsb.ekf.lan0116.eventSystem.events.hero;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;

/**
 * Triggered when player decides to rest
 */
public class RestEvent implements Event {
    @Override
    public EventType getType() {
        return HeroType.REST;
    }
}
