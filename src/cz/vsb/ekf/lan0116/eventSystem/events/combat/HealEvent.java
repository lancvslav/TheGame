package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class HealEvent implements Event {

    private final Creature healedOne;
    private final float healAmount;

    public HealEvent(Creature healedOne, float healAmount) {
        this.healedOne = healedOne;
        this.healAmount = healAmount;
    }

    public Creature getHealedOne() {
        return healedOne;
    }

    public float getHealAmount() {
        return healAmount;
    }

    @Override
    public EventType getType() {
        return CombatType.HEAL;
    }
}
