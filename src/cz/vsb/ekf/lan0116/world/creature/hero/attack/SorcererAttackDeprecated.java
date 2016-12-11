package cz.vsb.ekf.lan0116.world.creature.hero.attack;

import cz.vsb.ekf.lan0116.combat.AttackDeprecated;

public enum SorcererAttackDeprecated implements AttackDeprecated {
    LIGHT_BOLT(1.2f, 1),
    ARCANE_BOLT(1.1f, 1),;


    private final float damageMultiplier;
    private final float staminaConsumption;

    SorcererAttackDeprecated(float damageMultiplier, float staminaConsumption) {
        this.damageMultiplier = damageMultiplier;
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    public float getDamageMultiplier() {
        return damageMultiplier;
    }

    @Override
    public float getStaminaConsumption() {
        return staminaConsumption;
    }
}
