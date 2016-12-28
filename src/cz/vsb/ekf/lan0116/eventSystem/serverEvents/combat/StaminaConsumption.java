package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class StaminaConsumption implements FightResponse {

    private final Creature staminaUser;
    private final float staminaDecrease;

    public StaminaConsumption(Creature staminaUser, float staminaDecrease) {
        this.staminaUser = staminaUser;
        this.staminaDecrease = staminaDecrease;
    }

    @Override
    public FightResponseType getType() {
        return FightResponseType.STAMINA_CONSUMPTION;
    }

    public Creature getStaminaUser() {
        return staminaUser;
    }

    public float getStaminaDecrease() {
        return staminaDecrease;
    }
}
