package cz.vsb.ekf.lan0116.eventsHandling.failures;


import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public enum EquipFailure implements FailureCause {
    CLAZZ_DIFF,
    NOT_A_WEAPON,;

    @Override
    public EventType getEventType() {
        return EventType.EQUIP;
    }
}
