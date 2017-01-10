package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.AttackMoveEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.EngageEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.eventSystem.failures.CombatFailure;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.BattleLogServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.FightResponse;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.HeroInteraction;
import cz.vsb.ekf.lan0116.world.location.type.LocationSuperType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling.FightUtils.attack;
import static cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling.FightUtils.selectAttack;

public class CombatChannel extends EventHandler {

    public CombatChannel(Hero hero, World world, ResponseChannel responseChannel) {
        super(hero, world, responseChannel);
    }

    @Override
    public Response handleEvent(Event rawEvent) {
        Hero hero = this.getHero();
        CombatType eventType = (CombatType) rawEvent.getType();
        switch (eventType) {
            case ATTACK_MOVE:
                // if (not in combat) return Response.FUCK_YOU;
                List<FightResponse> battleLog = new ArrayList<>();
                AttackMoveEvent moveEvent = (AttackMoveEvent) rawEvent;
                Attack heroAttack = moveEvent.getAttack();
                Creature enemy = hero.getHeroInteraction().getCurrentEnemy();
                battleLog.addAll(attack(hero, heroAttack, enemy));
                if (enemy.isAlive()) {
                    battleLog.addAll(attack(enemy, selectAttack(enemy), hero));
                } else {
                    if (hero.getHeroInteraction().getEnemyQueue().isEmpty()) {
                        hero.getHeroInteraction().setStatus(HeroInteraction.HeroStatus.READY);
                    }
                    hero.getHeroInteraction().getEnemyQueue().remove();
                }
                getResponseChannel().respond(new BattleLogServerEvent(battleLog));
                if (!hero.isAlive()) {
                    return new Response(CombatFailure.YOU_DIED);
                }
                return Response.SUCCESS;
            case ENGAGE:
                EngageEvent engageEvent = (EngageEvent) rawEvent;
                LinkedList<Creature> queue = new LinkedList<>();
                queue.add(engageEvent.getEnemy());
                hero.getHeroInteraction().setEnemyQueue(queue);
                hero.getHeroInteraction().setStatus(HeroInteraction.HeroStatus.IN_COMBAT);
                return null;
            case FLEE:
                if (hero.getCurrentStamina() < 3) {
                    return new Response(CombatFailure.FLEE_WEAK);
                }
                //if (hero.getHeroInteraction().getPosition().equals(new Arena("test"))) { PROČ TO NEJDEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE -> VLASEC? DON'T KILL ME THO
                if (hero.getHeroInteraction().getPosition().getSuperType().equals(LocationSuperType.ARENA)) {
                    return new Response(CombatFailure.FLEE_DISABLED);
                }
                hero.getHeroInteraction().setEnemyQueue(null);
                hero.getHeroInteraction().setStatus(HeroInteraction.HeroStatus.READY);
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + rawEvent.getType() + " is not supported.");
        }
    }
}
