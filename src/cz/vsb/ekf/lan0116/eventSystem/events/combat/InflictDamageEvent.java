package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class InflictDamageEvent implements Event {

    private final Creature damagedOne;
    private float damage;

    public InflictDamageEvent(Creature damagedOne, float damage) {
        this.damagedOne = damagedOne;
        this.damage = damage;
    }

    public Creature getDamagedOne() {
        return damagedOne;
    }

    public float getDamage() {
        return damage;
    }

    @Override
    public EventType getType() {
        return CombatType.INFLICT_DAMAGE;
    }

}
