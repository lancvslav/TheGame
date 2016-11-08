package cz.vsb.ekf.lan0116.world.creature.hero.attack;

public enum SorcererAttacks implements HeroAttacks {
    LIGHT_BOLT(1.2f, 1),
    ARCANE_BOLT(1.1f, 1),;


    private final float damageMultiplier;
    private final float staminaConsumption;

    SorcererAttacks(float damageMultiplier, float staminaConsumption) {
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
