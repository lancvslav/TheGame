package cz.vsb.ekf.lan0116.eventSystem.events.hero.npc;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

/**
 * Triggered when chosen to talk with npc (npc does the talking)
 */
public class TalkEvent implements Event {

    private Humanoid npc;

    public TalkEvent(Humanoid npc) {
        this.npc = npc;
    }

    public Humanoid getNpc() {
        return npc;
    }


    @Override
    public EventType getType() {
       return HeroType.TALK;
    }
}
