package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel.CombatChannel;
import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel.GameChannel;
import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel.HeroChannel;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class EventPublisher {

    private final Hero hero;
    private final World world;
    private final CombatChannel combatChannel;
    private final GameChannel gameChannel;
    private final HeroChannel heroChannel;

    public EventPublisher(Hero hero, World world) {
        this.hero = hero;
        this.world = world;
        this.combatChannel = new CombatChannel(hero, world);
        this.gameChannel = new GameChannel(hero, world);
        this.heroChannel = new HeroChannel(hero, world);
    }

    public void publishEvent(Event event) {

    }

    public void channelize(Event event) {
        switch (event.getSuperType()) {
            case COMBAT:
                this.combatChannel.handleEvent(event);
                break;
            case GAME:
                this.gameChannel.handleEvent(event);
                break;
            case HERO:
                this.heroChannel.handleEvent(event);
                break;
            default:
                throw new UnsupportedOperationException("Channel " + event.getSuperType() + " is not supported.");
        }

    }
}
