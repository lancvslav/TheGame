package cz.vsb.ekf.lan0116.world.creature.enemy;

import cz.vsb.ekf.lan0116.combat.AttackDeprecated;

public enum EnemyAttackDeprecated implements AttackDeprecated {
    BACKSTAB(2, 5f),//DOUBLE DMG
    BLEED(1, 2f),//DMG APPLIED TWICE, SECOND TIME REDUCED BY HALF
    //BLIND(2,2f)  ,//WEAKEN RANGED ATTACK
    CRUSHING_BLOW(1, 3f),//IGNORES PART OF TARGETS DEFENSE
    //FEAR(10),//RESTRICTS ATTACK FOR ONE "LAP"
    HIT(1, 0f),
    //INITIATIVE,
    LIFESTEAL(1, 2),//DRAIN HALF OF HP TAKEN FROM TARGET
    MAGIC_BOLT(1.5f, 2),
    //POISON(2),//DEALS DMG PERIODICALLY
    //SCREAM(2),//REDUCES ALL ENEMY'S STATS BY 1
    SHOOT(2, 2),//ATTACK TWICE
    //SILENCE(5),//WEAKEN MAGIC ATTACK
    //WEAKEN(2),//WEAKEN PHYSICAL ATTACK
    ;

    private final float damageMultiplier;
    private final float staminaConsumption;

    EnemyAttackDeprecated(float damageMultiplier, float staminaConsumption) {
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
