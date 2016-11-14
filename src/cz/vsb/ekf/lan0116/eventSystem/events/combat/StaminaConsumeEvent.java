package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class StaminaConsumeEvent implements Event {

    private final Creature staminaUser;
    private final float consumeValue;

    public StaminaConsumeEvent(Creature staminaUser, float consumeValue) {
        this.staminaUser = staminaUser;
        this.consumeValue = consumeValue;
    }

    public Creature getStaminaUser() {
        return staminaUser;
    }

    public float getConsumeValue() {
        return consumeValue;
    }

    @Override
    public EventType getType() {
        return CombatType.STAMINA_CONSUMPTION;
    }
}
