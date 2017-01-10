package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.CombatChannel;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.GameChannel;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.HeroChannel;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class EventPublisher {

    private final CombatChannel combatChannel;
    private final GameChannel gameChannel;
    private final HeroChannel heroChannel;

    public EventPublisher(Hero hero, World world, ResponseChannel responseChannel) {
        this.combatChannel = new CombatChannel(hero, world, responseChannel);
        this.gameChannel = new GameChannel(hero, world, responseChannel);
        this.heroChannel = new HeroChannel(hero, world, responseChannel);
    }

    private CombatChannel getCombatChannel() {
        return combatChannel;
    }

    private GameChannel getGameChannel() {
        return gameChannel;
    }

    private HeroChannel getHeroChannel() {
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
