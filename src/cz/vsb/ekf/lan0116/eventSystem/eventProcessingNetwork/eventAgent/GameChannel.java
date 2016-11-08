package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventHandler;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.ResponseChannel;
import cz.vsb.ekf.lan0116.eventSystem.events.type.GameType;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.game.GameOverResponse;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.HeroInteraction;

public class GameChannel extends EventHandler {

    public GameChannel(Hero hero, World world, ResponseChannel responseChannel) {
        super(hero, world, responseChannel);
    }

    @Override
    public Response handleEvent(Event event) {
        GameType eventType = (GameType) event.getType();
        switch (eventType) {
            case NEW_GAME:
                this.getHero().getHeroInteraction().setPosition(this.getWorld().getStartLocation());
                this.getHero().getHeroInteraction().setStatus(HeroInteraction.HeroStatus.READY);
                return Response.SUCCESS;
            case RESPAWN:
                this.getHero().setCurrentLifeEssence(this.getHero().getMaxLifeEssence());
                this.getHero().getHeroInteraction().setPosition(this.getWorld().getStartLocation());
                return Response.SUCCESS;
            case GIVE_UP:
                this.getResponseChannel().respond(new GameOverResponse(GameOverResponse.Reason.SURRENDER));
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
