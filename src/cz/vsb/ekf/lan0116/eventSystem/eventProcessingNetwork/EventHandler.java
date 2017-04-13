package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork;

import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.HeroInteraction;

public abstract class EventHandler implements EventSubscriber {

    private final Hero hero;
    private final World world;
    private final ResponseChannel responseChannel;

    public EventHandler(Hero hero, World world, ResponseChannel responseChannel) {
        this.hero = hero;
        this.world = world;
        this.responseChannel = responseChannel;
    }

    public Hero getHero() {
        return hero;
    }

    public World getWorld() {
        return world;
    }

    protected ResponseChannel getResponseChannel() {
        return responseChannel;
    }

    protected HeroInteraction getInteraction() {
        return this.getHero().getHeroInteraction();
    }
}
