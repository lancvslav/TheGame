package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class StaminaDecreaseEvent implements Event {

    private final Creature staminaUser;
    private final float staminaDecrease;

    public StaminaDecreaseEvent(Creature staminaUser, float staminaDecrease) {
        this.staminaUser = staminaUser;
        this.staminaDecrease = staminaDecrease;
    }

    public Creature getStaminaUser() {
        return staminaUser;
    }

    public float getStaminaDecrease() {
        return staminaDecrease;
    }

    @Override
    public EventType getType() {
        return CombatType.STAMINA_DECREASE;
    }
}
