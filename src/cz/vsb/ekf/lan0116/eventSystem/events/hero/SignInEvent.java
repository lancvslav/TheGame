package cz.vsb.ekf.lan0116.eventSystem.events.hero;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;

/**
 * Triggered when player signs in to the tournament
 */
public class SignInEvent implements Event {

    private final Tournament tournament;

    public SignInEvent(Tournament tournament) {
        this.tournament = tournament;
    }

    public Tournament getTournament() {
        return tournament;
    }

    @Override
    public EventType getType() {
        return HeroType.SIGN_IN;
    }
}
