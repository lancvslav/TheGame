package cz.vsb.ekf.lan0116.world.creature.hero.attack;

public enum WarriorAttack implements HeroAttack {
    STING(1, 0),
    QUICK_STAB(1.1f, 1),
    STRONG_STRIKE(1.2f, 1.1f),;

    private final float damageMultiplier;
    private final float staminaConsumption;

    WarriorAttack(float damageMultiplier, float staminaConsumption) {
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
