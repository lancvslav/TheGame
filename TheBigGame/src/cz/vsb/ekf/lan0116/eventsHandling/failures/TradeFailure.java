package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;

public enum TradeFailure implements FailureCause {
    NOT_ENOUGH_GOLD;;

    @Override
    public EventType getEventType() {
        return HeroType.TRADE;
    }
}
