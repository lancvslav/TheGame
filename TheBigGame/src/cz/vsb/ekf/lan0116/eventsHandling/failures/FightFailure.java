package cz.vsb.ekf.lan0116.eventsHandling.failures;

public enum FightFailure implements FailureCause {
    DONT_KNOW_YET,;

    @Override
    public EventTypeDeprecated getEventType() {
        return EventTypeDeprecated.FIGHT_ROUND_EVENT;
    }
}

