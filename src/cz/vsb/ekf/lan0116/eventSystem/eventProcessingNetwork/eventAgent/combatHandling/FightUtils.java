package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.*;
import cz.vsb.ekf.lan0116.world.creature.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightUtils {
    private static final Random random = new Random();

    public static List<FightResponse> attack(Creature attacker, Attack attack, Creature defender) {
        List<FightResponse> battleLog = new ArrayList<>();
        float staminaCost = attack.getStaminaConsumption();
        if (attacker.getCurrentStamina() >= staminaCost) {
            attacker.decreaseCurrentStamina(staminaCost);
            battleLog.add(new StaminaConsumption(attacker, staminaCost));
            float damageDealt = calculateDamage(powerOf(attacker, attack), defender.getDefense(), attack.getPenetration());
            defender.decreaseCurrentLifeEssence(damageDealt);
            battleLog.add(new DamageInfliction(attacker, defender, damageDealt));
            switch (attack.getProperty()) {
                case LIFESTEAL:
                    float stolen = damageDealt * 0.2f;
                    attacker.addCurrentLifeEssence(stolen);
                    battleLog.add(new Healing(attacker, stolen));
                    break;
                default:
                    throw new UnsupportedOperationException("not implemented yet");
            }
            if (defender.getCurrentLifeEssence() <= 0) {
                battleLog.add(new Information(defender, Information.Info.DEATH));
            }
        } else {
            battleLog.add(new Information(attacker, Information.Info.INSUFFICIENT_STAMINA));
        }
        return battleLog;
    }

    private static float powerOf(Creature attacker, Attack attack) {
        return attacker.getAttackPower() * attack.getMultiplier();
    }

    private static float calculateDamage(float totalAttackPower, float defenderDef, float penetration) {
        return totalAttackPower / (1 + (defenderDef / 10.0f) * (1 - penetration));
    }

    public static Attack selectAttack(Creature creature) {
        List<Attack> attacks = creature.getAttacks();
        int attackIndex = random.nextInt(attacks.size());
        if (creature.getCurrentStamina() >= attacks.get(attackIndex).getStaminaConsumption()) {
            return attacks.get(attackIndex);
        }

        // fallback - not enough stamina
        for (Attack attack : attacks) {
            if (creature.getCurrentStamina() >= attack.getStaminaConsumption()) {
                return attack;
            }
        }
        return Attack.FEEBLE_ATTACK;
    }
}
