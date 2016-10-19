package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;

public enum TradeFailure implements FailureCause {
    NOT_ENOUGH_GOLD;;

    @Override
    public EventType getEventType() {
        return HeroType.TRADE;
    }
}
