package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.CombatChannel;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.GameChannel;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.HeroChannel;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class EventPublisher {

    private final CombatChannel combatChannel;
    private final GameChannel gameChannel;
    private final HeroChannel heroChannel;

    public EventPublisher(Hero hero, World world) {
        this.combatChannel = new CombatChannel(hero, world);
        this.gameChannel = new GameChannel(hero, world);
        this.heroChannel = new HeroChannel(hero, world);
    }

    public CombatChannel getCombatChannel() {
        return combatChannel;
    }

    public GameChannel getGameChannel() {
        return gameChannel;
    }

    public HeroChannel getHeroChannel() {
        return heroChannel;
    }

    public Response getResponse(Event event) {
        return channelize(event);
    }

    private Response channelize(Event event) {
        switch (event.getSuperType()) {
            case COMBAT:
                return this.combatChannel.handleEvent(event);
            case GAME:
                return this.gameChannel.handleEvent(event);
            case HERO:
                return this.heroChannel.handleEvent(event);
            default:
                throw new UnsupportedOperationException("Channel " + event.getSuperType() + " is not supported.");
        }
    }
}
