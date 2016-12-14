package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.failures.CombatFailure;
import cz.vsb.ekf.lan0116.world.creature.Creature;

import java.util.List;
import java.util.Random;

public class AttackMoveHandle {

    private float damageToDefender;
    private float damageRetaliated;
    private float enemyStaminaDecrease;

    private float attackPower;
    private Creature defender;
    private Attack attack;
    private float attackerDef;

    public AttackMoveHandle(Creature defender, float attackPower, Attack attack, Float attackerDef) {
        this.defender = defender;
        this.attackPower = attackPower;
        this.attack = attack;
        this.attackerDef = attackerDef;
    }

    public float getDamageToDefender() {
        return damageToDefender;
    }

    public float getDamageRetaliated() {
        return damageRetaliated;
    }

    public float getEnemyStaminaDecrease() {
        return enemyStaminaDecrease;
    }

    private float calculateDamage(float attackPower, float defenderDef, Attack attack) {
        float damageDealt = (float)
                ((attackPower * attack.getMultiplier()) /
                        (1 + (defenderDef / 10.0) * (1 - attack.getPenetration())));
        if (damageDealt > 0) {
            return damageDealt;
        } else {
            return 0;
        }
    }

    public Response handleRound() {
        if (!defender.isAlive()) return new Response(CombatFailure.TARGET_DEAD);
        damageToDefender = this.calculateDamage(attackPower, defender.getDefense(), attack);
        damageRetaliated = this.calculateDamage(defender.getAttackPower(), attackerDef, this.getDefendersAttack());
        return Response.SUCCESS;
    }

    private Attack getDefendersAttack() {
        Random random = new Random();
        List<Attack> attacks = defender.getAttacks();
        int attackIndex = random.nextInt(attacks.size());
        Attack attack = attacks.get(attackIndex);
        if (defender.getCurrentStamina() >= attack.getStaminaConsumption()) return attack;
        while (defender.getCurrentStamina() >= attack.getStaminaConsumption()) {
            attackIndex = random.nextInt(attacks.size());
            attack = attacks.get(attackIndex);
        }
        enemyStaminaDecrease = attack.getStaminaConsumption();
        return attack;
    }
}






