package cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.EventHandler;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class HeroChannel extends EventHandler {

    public HeroChannel(Hero hero, World world) {
        super(hero, world);
    }

    @Override
    public <R extends Response> R handleEvent(Event<R> event) {
        HeroType eventType = (HeroType) event.getType();
        switch (eventType) {
            case DROP:
                break;
            case EQUIP:
                break;
            case TRADE:
                break;
            case TRAVEL:
                break;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
