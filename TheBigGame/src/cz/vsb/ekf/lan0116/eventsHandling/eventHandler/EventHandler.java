package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public abstract class EventHandler implements EventSubscriber {

    private final Hero hero;
    private final World world;

    public EventHandler(Hero hero, World world) {
        this.hero = hero;
        this.world = world;
    }

    public Hero getHero() {
        return hero;
    }

    public World getWorld() {
        return world;
    }
}
