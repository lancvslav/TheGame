package cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.EventHandler;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class GameChannel extends EventHandler {

    public GameChannel(Hero hero, World world) {
        super(hero, world);
    }

    @Override
    public <R extends Response> R handleEvent(Event<R> Event) {
        return null;
    }
}
