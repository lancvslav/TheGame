package cz.vsb.ekf.lan0116.eventsHandling.failures;

public enum TradeFailure implements FailureCause {
    NOT_ENOUGH_GOLD;
    ;

    @Override
    public EventTypeDeprecated getEventType() {
        return EventTypeDeprecated.TRADE;
    }
}
