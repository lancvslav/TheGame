package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling.FightRoundHandle;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.InflictDamageEvent;
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
        switch (eventType) {
            case INFLICT_DAMAGE:
                InflictDamageEvent inflictDamageEvent = (InflictDamageEvent) event;
                float currentHp = inflictDamageEvent.getDamagedOne().getCurrentLifeEssence();
                inflictDamageEvent.getDamagedOne()
                        .setCurrentLifeEssence(Math.max(0, currentHp - inflictDamageEvent.getDamage()));
                return Response.SUCCESS;
            case ROUND:
                FightRoundEvent fightRoundEvent = (FightRoundEvent) event;
                FightRoundHandle fightRoundHandle = new
                        FightRoundHandle(fightRoundEvent, fightRoundEvent.getAttack(), this);
                return fightRoundHandle.handleRound();
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
