package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.type.GameType;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class GameChannel extends EventHandler {

    public GameChannel(Hero hero, World world) {
        super(hero, world);
    }

    @Override
    public Response handleEvent(Event event) {
        GameType eventType = (GameType) event.getType();
        switch (eventType) {
            case NEW_GAME:
                this.getHero().getHeroInteraction().setPosition(this.getWorld().getStartLocation());
                return Response.SUCCESS;
            case RESPAWN:
                this.getHero().setCurrentLifeEssence(this.getHero().getMaxLifeEssence());
                this.getHero().getHeroInteraction().setPosition(this.getWorld().getStartLocation());
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
