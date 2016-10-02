package cz.vsb.ekf.lan0116.events;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class InflictDamageEvent extends Event {

    public final Creature creature;
    private float damage;

    public InflictDamageEvent(Creature creature, float damage) {
        super(EventType.INFLICT_DAMAGE);
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
}
