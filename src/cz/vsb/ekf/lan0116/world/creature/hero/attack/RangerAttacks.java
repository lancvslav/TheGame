package cz.vsb.ekf.lan0116.world.creature.hero.attack;

public enum RangerAttacks implements HeroAttacks {
    HAWK_STRIKE(1.2f, 1),
    QUICK_SHOT(1, 0),;

    private final float damageMultiplier;
    private final float staminaConsumption;

    RangerAttacks(float damageMultiplier, float staminaConsumption) {
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
