package cz.vsb.ekf.lan0116.eventsHandling.failures;


public enum TravelFailure implements FailureCause {
    NO_GATEWAY,;

    @Override
    public EventTypeDeprecated getEventType() {
        return EventTypeDeprecated.TRAVEL;
    }
}
