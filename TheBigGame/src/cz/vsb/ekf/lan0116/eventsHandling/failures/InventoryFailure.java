package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public enum InventoryFailure implements FailureCause {
    NOT_IN_INVENTORY,;

    @Override
    public EventType getEventType() {
        return null;
    }
}
