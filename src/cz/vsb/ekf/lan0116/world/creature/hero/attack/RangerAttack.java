package cz.vsb.ekf.lan0116.world.creature.hero.attack;

import cz.vsb.ekf.lan0116.combat.Attack;

public enum RangerAttack implements Attack {
    HAWK_STRIKE(1.2f, 1),
    QUICK_SHOT(1, 0),;

    private final float damageMultiplier;
    private final float staminaConsumption;

    RangerAttack(float damageMultiplier, float staminaConsumption) {
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