package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class AmbushEvent implements Event {

    private final Creature aggressor;

    public AmbushEvent(Creature aggressor) {
        this.aggressor = aggressor;
    }

    public Creature getAggressor() {
        return aggressor;
    }

    @Override
    public EventType getType() {
        return CombatType.AMBUSH;
    }
}
