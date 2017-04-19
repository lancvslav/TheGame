package cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping;

import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

/**
 * Triggered when player decides to talk about stuff with npc
 */
public class InitiateDialogueEvent implements Event {

    private Humanoid npc;

    public InitiateDialogueEvent(Humanoid npc) {
        this.npc = npc;
    }

    public Humanoid getNpc() {
        return npc;
    }

    @Override
    public EventType getType() {
        return HeroType.INITIATE_DIALOGUE;
    }
}
