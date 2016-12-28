package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class Healing implements FightResponse {
    private final Creature creature;
    private final float healed;

    public Healing(Creature creature, float healed) {
        this.creature = creature;
        this.healed = healed;
    }

    public Creature getCreature() {
        return creature;
    }

    public float getHealed() {
        return healed;
    }

    @Override
    public FightResponseType getType() {
        return FightResponseType.HEALING;
    }
}
