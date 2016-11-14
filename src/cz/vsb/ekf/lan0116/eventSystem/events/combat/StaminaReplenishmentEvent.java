package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class StaminaReplenishmentEvent implements Event {

    private final Creature staminaUser;
    private final float replenishValue;

    public StaminaReplenishmentEvent(Creature staminaUser, float replenishValue) {
        this.staminaUser = staminaUser;
        this.replenishValue = replenishValue;
    }

    public Creature getStaminaUser() {
        return staminaUser;
    }

    public float getReplenishValue() {
        return replenishValue;
    }

    @Override
    public EventType getType() {
        return CombatType.STAMINA_REPLENISHMENT;
    }
}
