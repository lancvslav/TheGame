package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling.AttackMoveHandle;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.DamageInflictionEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.HealEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.StaminaConsumeEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.eventSystem.failures.CombatFailure;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class CombatChannel extends EventHandler {

    public CombatChannel(Hero hero, World world, ResponseChannel responseChannel) {
        super(hero, world, responseChannel);
    }

    @Override
    public Response handleEvent(Event event) {
        CombatType eventType = (CombatType) event.getType();
        float currentLifeEssence;
        float currentStamina;
        switch (eventType) {
            case ATTACK_MOVE:
                FightRoundEvent fightRoundEvent = (FightRoundEvent) event;
                Creature enemy = fightRoundEvent.getEnemy();
                if (fightRoundEvent.getAttack().getStaminaConsumption()
                        > this.getHero().getCurrentStamina()) return new Response(CombatFailure.NOT_ENOUGH_STAMINA);
                AttackMoveHandle attackMoveHandle = new AttackMoveHandle(fightRoundEvent.getEnemy(),
                        this.getHero().getAttackPower(), fightRoundEvent.getAttack(), this.getHero().getDefense());
                if (!attackMoveHandle.handleRound().isSuccess()) return new Response(CombatFailure.TARGET_DEAD);
                new StaminaConsumeEvent(this.getHero(), fightRoundEvent.getAttack().getStaminaConsumption());
//                this.getHero().setCurrentStamina(this.max(this.getHero().getCurrentStamina() - fightRoundEvent
//                        .getAttack().getStaminaConsumption()));
                new DamageInflictionEvent(enemy, attackMoveHandle.getDamageToDefender());
//                enemy.setCurrentLifeEssence(this.max(enemy.getCurrentLifeEssence() - attackMoveHandle
//                        .getDamageToDefender()));
                if (!enemy.isAlive()) return new Response(CombatFailure.ENEMY_DEAD);
                new StaminaConsumeEvent(enemy, attackMoveHandle.getEnemyStaminaDecrease());
//                enemy.setCurrentStamina(this.max(enemy.getCurrentStamina() - attackMoveHandle
//                        .getEnemyStaminaDecrease()));
                new DamageInflictionEvent(this.getHero(), attackMoveHandle.getDamageRetaliated());
//                this.getHero().setCurrentLifeEssence(this.max(
//                        this.getHero().getCurrentLifeEssence() - attackMoveHandle.getDamageRetaliated()));
                if (!this.getHero().isAlive()) return new Response(CombatFailure.YOU_DIED);
                return Response.SUCCESS;
            case DAMAGE_INFLICTION:
                DamageInflictionEvent damageInflictionEvent = (DamageInflictionEvent) event;
                currentLifeEssence = damageInflictionEvent.getDamagedOne().getCurrentLifeEssence();
                damageInflictionEvent.getDamagedOne()
                        .setCurrentLifeEssence(this.max(currentLifeEssence - damageInflictionEvent.getDamage()));
                return Response.SUCCESS;
            case HEAL:
                HealEvent healEvent = (HealEvent) event;
                currentLifeEssence = healEvent.getHealedOne().getCurrentLifeEssence();
                healEvent.getHealedOne().setCurrentLifeEssence(Math.min(
                        healEvent.getHealedOne().getMaxLifeEssence(), currentLifeEssence + healEvent.getHealAmount()));
                return Response.SUCCESS;
            case STAMINA_CONSUMPTION:
                StaminaConsumeEvent staminaConsumeEvent = (StaminaConsumeEvent) event;
                currentStamina = staminaConsumeEvent.getStaminaUser().getCurrentStamina();
                staminaConsumeEvent.getStaminaUser().setCurrentStamina(
                        this.max(currentStamina - staminaConsumeEvent.getConsumeValue()));
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }

    private float max(float a) {
        return Math.max(a, 0);
    }
}
