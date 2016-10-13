package cz.vsb.ekf.lan0116.eventsHandling.failures;

public enum InventoryFailure implements FailureCause {
    NOT_IN_INVENTORY,;

    @Override
    public EventTypeDeprecated getEventType() {
        return null;
    }
}
