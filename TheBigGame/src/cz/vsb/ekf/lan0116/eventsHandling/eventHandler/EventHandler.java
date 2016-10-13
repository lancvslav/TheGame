package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public abstract class EventHandler implements EventSubscriber {

    private final Hero hero;
    private final World world;

    public EventHandler(Hero hero, World world) {
        this.hero = hero;
        this.world = world;
    }

    @Override
    public <R extends Response> R handleEvent(Event<R> Event) {
        return null;
    }
}
