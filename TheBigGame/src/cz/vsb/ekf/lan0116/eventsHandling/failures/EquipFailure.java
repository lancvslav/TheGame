package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.eventsHandling.events.type.HeroType;

public enum EquipFailure implements FailureCause {
    CLAZZ_DIFF,
    NOT_A_WEAPON,;

    @Override
    public EventType getEventType() {
        return HeroType.EQUIP;
    }
}
