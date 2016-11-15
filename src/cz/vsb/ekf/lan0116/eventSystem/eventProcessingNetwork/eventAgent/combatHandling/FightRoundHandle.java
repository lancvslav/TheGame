package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.failures.CombatFailure;
import cz.vsb.ekf.lan0116.world.creature.Creature;

import static cz.vsb.ekf.lan0116.world.creature.enemy.EnemyAttack.*;
import static cz.vsb.ekf.lan0116.world.creature.hero.attack.RangerAttack.*;
import static cz.vsb.ekf.lan0116.world.creature.hero.attack.SorcererAttack.*;
import static cz.vsb.ekf.lan0116.world.creature.hero.attack.WarriorAttack.*;

public class FightRoundHandle {

    private float damageToEnemy;
    private float damageToHero;

    private float staminaConsumed;

    public FightRoundHandle() {
    }

    public float getDamageToEnemy() {
        return damageToEnemy;
    }

    public float getDamageToHero() {
        return damageToHero;
    }

//    public Response handleRound() {
//        float hitPower;
//
//        hitPower = hero.getAttack() * (heroAttack.getDamageMultiplier());
//
//        damageToEnemy = defending(enemy, hitPower);
//
//        this.combatChannel.handleEvent(new DamageInflictionEvent(enemy, damageToEnemy));
//        this.combatChannel.handleEvent(new StaminaConsumeEvent
//                (hero, heroAttack.getStaminaConsumption()));
//
//        if (!enemy.isAlive()) return new Response(CombatFailure.ENEMY_DEAD);
//
//        if (enemy.getCurrentStamina() >= enemy.getSpecialAttack().getStaminaConsumption()) {
//            damageToHero = this.handleAttack(enemy.getAttack(), enemy.getSpecialAttack());
//            this.combatChannel.handleEvent(new StaminaConsumeEvent
//                    (enemy, enemy.getSpecialAttack().getStaminaConsumption()));
//        } else {
//            damageToHero = this.defending(hero, hitPower);
//        }
//        this.combatChannel.handleEvent(new DamageInflictionEvent(hero, damageToHero));
//
//        if (!hero.isAlive()) return new Response(CombatFailure.HERO_DEAD);
//
//        return Response.SUCCESS;
//    }

    private float defending(Creature beingAttacked, float hitPower) {
        float damageDone = ((hitPower) / (1 + (beingAttacked.getDefense() / 100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }

    private Response handleAttack(Creature attacker, Attack attack, Creature defender) {

        if (!defender.isAlive()) return new Response(CombatFailure.ENEMY_DEAD);

        float damage;
        float attackerAtt = attacker.getAttack();
        float attackerCLE = attacker.getCurrentLifeEssence();
        float attackerCS = attacker.getCurrentStamina();
        float defenderCLE = defender.getCurrentLifeEssence();
        float defenderCS = defender.getCurrentStamina();
        float staminaCon = attack.getStaminaConsumption();

        if (attackerCS < staminaCon) {
            damage = this.defending(defender, attackerAtt);
            defender.setCurrentLifeEssence(this.max(defenderCLE - damage));
            attacker.setCurrentStamina(this.max(attackerCS - staminaCon));
            return Response.SUCCESS;
        }

        switch (attack) {
            /*
            EnemyAttacks
             */
            case BACKSTAB:
                damage = this.defending(defender, (defender.getAttack() * attack.getDamageMultiplier()));
                break;
            case BLEED:
                damage = this.defending(defender, attackerAtt);
                damage += this.defending(defender, (attackerAtt / 2));
                break;
            case CRUSHING_BLOW:
                damage = ((attackerAtt) / (1 + ((defender.getDefense() / 0.7f) / 100)));
                break;
            case HIT:
                damage = this.defending(defender, attackerAtt);
                break;
            case LIFESTEAL:
                damage = this.defending(defender, attackerAtt);
                float stolenEssence = damage * 0.3f;
                attacker.setCurrentLifeEssence(Math.min(attacker.getMaxLifeEssence(), attackerCS + stolenEssence));
                break;
            case MAGIC_BOLT:
                damage = this.defending(defender, (attackerAtt * attack.getDamageMultiplier()));
                break;
            case SHOOT:
                damage = this.defending(defender, (attackerAtt * attack.getDamageMultiplier()));
                break;
            
                /*
                RangerAttacks
                 */
            case HAWK_STRIKE:
            case QUICK_SHOT:
                /*
                SorcererAttacks
                 */
            case ARCANE_BOLT:
            case LIGHT_BOLT:
                /*
                WarriorAttacks
                 */
            case QUICK_STAB:
            case STING:
            case STRONG_STRIKE:
            default:
                return new Response(CombatFailure.UNKNOWN);
        }

        attacker.setCurrentStamina(this.max(attackerCS - staminaCon));
        defender.setCurrentLifeEssence(this.max(defenderCLE - damage));
        return Response.SUCCESS;
    }

    private float max(float a) {
        return Math.max(a, 0);
    }
}

//CHECKING, WHETHER ENEMY SHOULD START FIRST
//        boolean enemyStarts = enemy.getSpecialAttack().equals(EnemyAttack.INITIATIVE);
//        if (enemyStarts) {
//            fighter0 = enemy;
//            fighter1 = hero;
//        }



