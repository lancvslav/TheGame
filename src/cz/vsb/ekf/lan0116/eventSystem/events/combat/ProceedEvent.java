package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;

@Deprecated
public class ProceedEvent implements Event {
    @Override
    public EventType getType() {
        return CombatType.PROCEED;
    }
}
