package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.BattleLogServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.FightResponse;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.ArrayList;
import java.util.List;

import static cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling.FightUtils.attack;
import static cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling.FightUtils.selectAttack;

public class CombatChannel extends EventHandler {

    public CombatChannel(Hero hero, World world, ResponseChannel responseChannel) {
        super(hero, world, responseChannel);
    }

    @Override
    public Response handleEvent(Event rawEvent) {
        CombatType eventType = (CombatType) rawEvent.getType();
        switch (eventType) {
            case ATTACK_MOVE:
                // if (not in combat) return Response.FUCK_YOU;
                List<FightResponse> battleLog = new ArrayList<>();
                FightRoundEvent event = (FightRoundEvent) rawEvent;
                Hero hero = getHero();
                Attack heroAttack = event.getAttack();
                Creature enemy = hero.getHeroInteraction().getCurrentEnemy();
                battleLog.addAll(attack(hero, heroAttack, enemy));
                if (enemy.getCurrentLifeEssence() > 0) {
                    battleLog.addAll(attack(enemy, selectAttack(enemy), hero));
                }
                getResponseChannel().respond(new BattleLogServerEvent(battleLog));

                return Response.SUCCESS;

            default:
                throw new UnsupportedOperationException("Event type " + rawEvent.getType() + " is not supported.");
        }
    }
}
