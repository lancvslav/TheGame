package cz.vsb.ekf.lan0116.eventSystem.failures;

import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.HeroType;

public enum EquipFailure implements FailureCause {
    CLAZZ_DIFF,
    NOT_A_WEAPON,;

    @Override
    public EventType getEventType() {
        return HeroType.EQUIP;
    }
}
