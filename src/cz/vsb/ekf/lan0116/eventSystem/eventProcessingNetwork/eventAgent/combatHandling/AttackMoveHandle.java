package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.failures.CombatFailure;
import cz.vsb.ekf.lan0116.eventSystem.failures.StaminaFailure;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class AttackMoveHandle {

    private float damageToDefender;
    private float staminaConsumed;

    private float attackPower;
    private Creature defender;
    private Attack attack;

    public AttackMoveHandle(Creature defender, float attackPower, Attack attack) {
        this.defender = defender;
        this.attackPower = attackPower;
        this.attack = attack;
    }

//    public Response handleRound() {
//        float hitPower;
//
//        hitPower = hero.getAttack() * (heroAttack.getDamageMultiplier());
//
//        damageToEnemy = calculateDamage(enemy, hitPower);
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
//            damageToHero = this.calculateDamage(hero, hitPower);
//        }
//        this.combatChannel.handleEvent(new DamageInflictionEvent(hero, damageToHero));
//
//        if (!hero.isAlive()) return new Response(CombatFailure.HERO_DEAD);
//
//        return Response.SUCCESS;
//    }

    private float calculateDamage() {
        float damageDealt = (float)
                (attackPower /
                        (1 + (defender.getDefense() / 10.0) * (1 - attack.getPenetration())));
        if (damageDealt > 0) {
            return damageDealt;
        } else {
            return 0;
        }
    }

    private Response handleAttack() {

        if (!defender.isAlive()) return new Response(CombatFailure.ENEMY_DEAD);

        float damage;
        float attackerAtt = attacker.getAttackPower();
        float attackerCLE = attacker.getCurrentLifeEssence();
        float attackerCS = attacker.getCurrentStamina();
        float defenderCLE = defender.getCurrentLifeEssence();
        float defenderCS = defender.getCurrentStamina();
        float staminaCon = attack.getStaminaConsumption();

        if (attackerCS < staminaCon) {
            damage = this.calculateDamage();
            defender.setCurrentLifeEssence(this.max(defenderCLE - damage));
            attacker.setCurrentStamina(this.max(attackerCS - staminaCon));
            return Response.SUCCESS;
        } else {
            return new Response(StaminaFailure.NOT_ENOUGH_STAMINA);
        }
    }
//        switch (attackDeprecated) {
//            /*
//            EnemyAttacks
//             */
//            case BACKSTAB:
//                damage = this.calculateDamage(defender, (defender.getAttackPower() * attackDeprecated.getDamageMultiplier()));
//                break;
//            case BLEED:
//                damage = this.calculateDamage(defender, attackerAtt);
//                damage += this.calculateDamage(defender, (attackerAtt / 2));
//                break;
//            case CRUSHING_BLOW:
//                damage = ((attackerAtt) / (1 + ((defender.getDefense() / 0.7f) / 100)));
//                break;
//            case HIT:
//                damage = this.calculateDamage(defender, attackerAtt);
//                break;
//            case LIFESTEAL:
//                damage = this.calculateDamage(defender, attackerAtt);
//                float stolenEssence = damage * 0.3f;
//                attacker.setCurrentLifeEssence(Math.min(attacker.getMaxLifeEssence(), attackerCS + stolenEssence));
//                break;
//            case MAGIC_BOLT:
//                damage = this.calculateDamage(defender, (attackerAtt * attackDeprecated.getDamageMultiplier()));
//                break;
//            case SHOOT:
//                damage = this.calculateDamage(defender, (attackerAtt * attackDeprecated.getDamageMultiplier()));
//                break;
//
//                /*
//                RangerAttacks
//                 */
//            case HAWK_STRIKE:
//            case QUICK_SHOT:
//                /*
//                SorcererAttacks
//                 */
//            case ARCANE_BOLT:
//            case LIGHT_BOLT:
//                /*
//                WarriorAttacks
//                 */
//            case QUICK_STAB:
//            case STING:
//            case STRONG_STRIKE:
//            default:
//                return new Response(CombatFailure.UNKNOWN);
//        }

    private float max(float a) {
        return Math.max(a, 0);
    }
}





