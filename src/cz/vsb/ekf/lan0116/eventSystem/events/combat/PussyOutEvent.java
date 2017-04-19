package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

/**
 * Triggered when player back off from the tournament
 */
public class PussyOutEvent implements Event {
    @Override
    public EventType getType() {
        return CombatType.PUSSY_OUT;
    }
}
