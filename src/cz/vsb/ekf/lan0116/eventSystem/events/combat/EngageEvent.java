package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class EngageEvent implements Event {

    private final Creature enemy;

    public EngageEvent(Creature enemy) {
        this.enemy = enemy;
    }

    @Override
    public EventType getType() {
        return CombatType.ENGAGE;
    }

    public Creature getEnemy() {
        return enemy;
    }
}
