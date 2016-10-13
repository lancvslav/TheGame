package cz.vsb.ekf.lan0116.eventsHandling.failures;


public enum EquipFailure implements FailureCause {
    CLAZZ_DIFF,
    NOT_A_WEAPON,;

    @Override
    public EventTypeDeprecated getEventType() {
        return EventTypeDeprecated.EQUIP;
    }
}
