package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public enum TradeFailure implements FailureCause {
    NOT_ENOUGH_GOLD;
    ;

    @Override
    public EventType getEventType() {
        return EventType.TRADE;
    }
}
