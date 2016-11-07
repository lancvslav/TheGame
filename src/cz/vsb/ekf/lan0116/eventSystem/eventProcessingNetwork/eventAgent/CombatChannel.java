package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.InflictDamageEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class CombatChannel extends EventHandler {

    public CombatChannel(Hero hero, World world) {
        super(hero, world);
    }

    @Override
    public Response handleEvent(Event event) {
        CombatType eventType = (CombatType) event.getType();
        switch (eventType) {
            case INFLICT_DAMAGE:
                return Response.SUCCESS;
            case ROUND:
                InflictDamageEvent inflictDamageEvent = (InflictDamageEvent) event;
                float currentHp = inflictDamageEvent.getCreature().getCurrentLifeEssence();
                inflictDamageEvent.getCreature().setCurrentLifeEssence(currentHp - inflictDamageEvent.getDamage());
                if (inflictDamageEvent.getCreature().getCurrentLifeEssence() < 0) {
                    inflictDamageEvent.getCreature().setCurrentLifeEssence(0);
                }
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
