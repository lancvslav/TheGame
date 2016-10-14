package cz.vsb.ekf.lan0116.eventsHandling.events.combat;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class InflictDamageEvent implements Event {

    public final Creature creature;
    private float damage;

    public InflictDamageEvent(Creature creature, float damage) {
        this.creature = creature;
        this.damage = damage;
    }

    public Creature getCreature() {
        return creature;
    }

    public float getDamage() {
        return damage;
    }

    void setDamage(float damage) {
        this.damage = damage;
    }

    @Override
    public EventType getType() {
        return CombatType.INFLICT_DAMAGE;
    }

}
