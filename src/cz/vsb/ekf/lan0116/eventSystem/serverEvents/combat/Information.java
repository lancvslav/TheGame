package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class Information implements FightResponse {
    private final Creature subject;
    private final Info message;

    public Information(Creature subject, Info message) {
        this.subject = subject;
        this.message = message;
    }

    public Creature getSubject() {
        return subject;
    }

    public Info getMessage() {
        return message;
    }

    @Override
    public FightResponseType getType() {
        return FightResponseType.INFORMATION;
    }

    public enum Info {
        DEATH,
        INSUFFICIENT_STAMINA,
    }
}
