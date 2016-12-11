package cz.vsb.ekf.lan0116.world.creature.hero.attack;

import cz.vsb.ekf.lan0116.combat.AttackDeprecated;

public enum RangerAttackDeprecated implements AttackDeprecated {
    HAWK_STRIKE(1.2f, 1),
    QUICK_SHOT(1, 0),;

    private final float damageMultiplier;
    private final float staminaConsumption;

    RangerAttackDeprecated(float damageMultiplier, float staminaConsumption) {
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
