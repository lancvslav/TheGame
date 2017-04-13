package cz.vsb.ekf.lan0116.eventSystem.events.hero.npc;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

/**
 * Triggered when player chose to stop talking with npc, after that he is still interacting with that npc though
 */
public class StopTalkingEvent implements Event {

    private Humanoid npc;

    public StopTalkingEvent(Humanoid npc) {
        this.npc = npc;
    }

    public Humanoid getNpc() {
        return npc;
    }

    @Override
    public EventType getType() {
        return HeroType.STOP_TALKING;
    }
}
