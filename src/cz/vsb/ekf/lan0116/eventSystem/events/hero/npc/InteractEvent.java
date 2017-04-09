package cz.vsb.ekf.lan0116.eventSystem.events.hero.npc;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.creature.Creature;

/**
 * Event fired when chosen to interact with some npc, interacting gives opportunities to talk, shop etc.
 */
public class InteractEvent implements Event {

    private Creature npc;

    public InteractEvent(Creature npc) {
        this.npc = npc;
    }

    public Creature getNpc() {
        return npc;
    }

    @Override
    public EventType getType() {
        return HeroType.INTERACT;
    }
}
