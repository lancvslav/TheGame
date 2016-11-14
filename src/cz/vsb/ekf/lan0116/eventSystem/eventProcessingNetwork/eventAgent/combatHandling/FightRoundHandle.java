package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.CombatChannel;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.DamageInflictionEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.HealEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.StaminaConsumeEvent;
import cz.vsb.ekf.lan0116.eventSystem.failures.FightFailure;
import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyAttack;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.attack.HeroAttack;

public class FightRoundHandle {

    private final CombatChannel combatChannel;
    private final Hero hero;
    private final HeroAttack heroAttack;
    private final Enemy enemy;
    private float stolenEssence;
    private float damageToEnemy;
    private float damageToHero;

    public FightRoundHandle(FightRoundEvent event, HeroAttack heroAttack, CombatChannel combatChannel) {
        this.hero = event.getHero();
        this.combatChannel = combatChannel;
        this.heroAttack = heroAttack;
        this.enemy = event.getEnemy();
    }

    public Response handleRound() {
        float hitPower;

        hitPower = hero.getAttack() * (heroAttack.getDamageMultiplier());

        damageToEnemy = defending(enemy, hitPower);

        this.combatChannel.handleEvent(new DamageInflictionEvent(enemy, damageToEnemy));
        this.combatChannel.handleEvent(new StaminaConsumeEvent
                (hero, heroAttack.getStaminaConsumption()));

        if (!enemy.isAlive()) return new Response(FightFailure.ENEMY_DEAD);

        if (enemy.getCurrentStamina() >= enemy.getSpecialAttack().getStaminaConsumption()) {
            damageToHero = this.handleEnemyAttack(enemy.getAttack(), enemy.getSpecialAttack());
            this.combatChannel.handleEvent(new StaminaConsumeEvent
                    (enemy, enemy.getSpecialAttack().getStaminaConsumption()));
        } else {
            damageToHero = this.defending(hero, hitPower);
        }
        this.combatChannel.handleEvent(new DamageInflictionEvent(hero, damageToHero));

        if (!hero.isAlive()) return new Response(FightFailure.HERO_DEAD);

        return Response.SUCCESS;
    }

    private float defending(Creature beingAttacked, float hitPower) {
        float damageDone = ((hitPower) / (1 + (beingAttacked.getDefense() / 100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }

    private float handleEnemyAttack(float hitPower, EnemyAttack attack) {
        float damagePortion;
        switch (attack) {
            case BACKSTAB:
                return this.defending(hero, (hitPower * 2));
            case BLEED:
                damagePortion = this.defending(hero, hitPower);
                damagePortion += this.defending(hero, (hitPower / 2));
                return damagePortion;
            case CRUSHING_BLOW:
                return ((hitPower) / (1 + ((hero.getDefense() / 0.7f) / 100)));
            case HIT:
                return this.defending(hero, hitPower);
            case LIFESTEAL:
                damagePortion = this.defending(hero, hitPower);
                stolenEssence = damagePortion * 0.3f;
                this.combatChannel.handleEvent(new HealEvent(enemy, stolenEssence));
                return damagePortion;
            case MAGIC_BOLT:
                return this.defending(hero, (hitPower * 1.2f));
            case SHOOT:
                this.defending(hero, (hitPower * 2));
            default:
                return this.defending(hero, hitPower);
        }
    }

}

//CHECKING, WHETHER ENEMY SHOULD START FIRST
//        boolean enemyStarts = enemy.getSpecialAttack().equals(EnemyAttack.INITIATIVE);
//        if (enemyStarts) {
//            fighter0 = enemy;
//            fighter1 = hero;
//        }



