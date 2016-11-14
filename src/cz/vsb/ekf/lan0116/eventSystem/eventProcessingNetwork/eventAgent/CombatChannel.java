package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling.FightRoundHandle;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.DamageInflictionEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.HealEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.StaminaConsumeEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.world.World;
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
            case DAMAGE_INFLICTION:
                DamageInflictionEvent damageInflictionEvent = (DamageInflictionEvent) event;
                currentLifeEssence = damageInflictionEvent.getDamagedOne().getCurrentLifeEssence();
                damageInflictionEvent.getDamagedOne()
                        .setCurrentLifeEssence(Math.max(0, currentLifeEssence - damageInflictionEvent.getDamage()));
                return Response.SUCCESS;
            case HEAL:
                HealEvent healEvent = (HealEvent) event;
                currentLifeEssence = healEvent.getHealedOne().getCurrentLifeEssence();
                healEvent.getHealedOne().setCurrentLifeEssence(Math.min(
                        healEvent.getHealedOne().getMaxLifeEssence(), currentLifeEssence + healEvent.getHealAmount()));
                return Response.SUCCESS;
            case ROUND:
                FightRoundEvent fightRoundEvent = (FightRoundEvent) event;
                FightRoundHandle fightRoundHandle = new
                        FightRoundHandle(fightRoundEvent, fightRoundEvent.getAttack(), this);
                return fightRoundHandle.handleRound();
            case STAMINA_CONSUMPTION:
                StaminaConsumeEvent staminaConsumeEvent = (StaminaConsumeEvent) event;
                currentStamina = staminaConsumeEvent.getStaminaUser().getCurrentStamina();
                staminaConsumeEvent.getStaminaUser().setCurrentStamina(
                        Math.max(0, currentStamina - staminaConsumeEvent.getConsumeValue()));
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
