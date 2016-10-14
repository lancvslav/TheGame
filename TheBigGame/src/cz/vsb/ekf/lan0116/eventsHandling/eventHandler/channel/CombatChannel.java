package cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.EventHandler;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.combat.InflictDamageEvent;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.CombatType;
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
                float currentHp = inflictDamageEvent.getCreature().getCurrentHp();
                inflictDamageEvent.getCreature().setCurrentHp(currentHp - inflictDamageEvent.getDamage());
                if (inflictDamageEvent.getCreature().getCurrentHp() < 0) {
                    inflictDamageEvent.getCreature().setCurrentHp(0);
                }
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
