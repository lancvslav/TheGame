package cz.vsb.ekf.lan0116.eventsHandling.eventHandler.channel;

import cz.vsb.ekf.lan0116.eventsHandling.GameResponse;
import cz.vsb.ekf.lan0116.eventsHandling.Response;
import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.EventHandler;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.GameType;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class GameChannel extends EventHandler {

    public GameChannel(Hero hero, World world) {
        super(hero, world);
    }

    @Override
    public <R extends Response> R handleEvent(Event<R> event) {
        GameType eventType = (GameType) event.getType();
        switch (eventType) {
            case NEW_GAME:
                this.getHero().setPosition(this.getWorld().getStartLocation());
                return new GameResponse();
            case RESPAWN:
                this.getHero().setCurrentHp(this.getHero().getMaxHp());
                this.getHero().setPosition(this.getWorld().getStartLocation());
                return Response.SUCCESS;
            default:
                throw new UnsupportedOperationException("Event type " + event.getType() + " is not supported.");
        }
    }
}
