package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;

public enum InventoryFailure implements FailureCause {
    NOT_IN_INVENTORY,;

    @Override
    public EventType getEventType() {
        return HeroType.EQUIP;
    }
}
