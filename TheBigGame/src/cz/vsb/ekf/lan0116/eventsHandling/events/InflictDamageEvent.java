package cz.vsb.ekf.lan0116.eventsHandling.events;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class InflictDamageEvent implements EventTypeInterface {

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
    public EventSuperType getEventSuperType() {
        return EventSuperType.FIGHT_EVENT;
    }
}
