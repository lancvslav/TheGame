package cz.vsb.ekf.lan0116.world.creature.enemy;

import cz.vsb.ekf.lan0116.combat.Attacks;

public enum EnemyAttacks implements Attacks {
    BACKSTAB(5f),//DOUBLE DMG
    BLEED(2f),//DMG APPLIED TWICE, SECOND TIME REDUCED BY HALF
    //BLIND(2)  ,//WEAKEN RANGED ATTACK
    CRUSHING_BLOW(3f),//ATTACK TWICE, NOT IN SINGLE HIT, BUT TWICE, SO DEFENSE MORE EFFICIENT
    //FEAR(10),//RESTRICTS ATTACK FOR ONE "LAP"
    HIT(0f),
    //INITIATIVE,
    LIFESTEAL(2),//DRAIN HALF OF HP TAKEN FROM TARGET
    MAGIC_BOLT(1),
    //POISON(2),//DEALS DMG PERIODICALLY
    //SCREAM(2),//REDUCES ALL ENEMY'S STATS BY 1
    SHOOT(2),//ATTACK TWICE
    //SILENCE(5),//WEAKEN MAGIC ATTACK
    //WEAKEN(2),//WEAKEN PHYSICAL ATTACK
    ;

    private final float staminaConsumption;

    EnemyAttacks(float staminaConsumption) {
        this.staminaConsumption = staminaConsumption;
    }

    @Override
    public float getStaminaConsumption() {
        return staminaConsumption;
    }
}
