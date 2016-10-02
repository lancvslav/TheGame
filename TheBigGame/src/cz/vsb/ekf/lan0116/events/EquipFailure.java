package cz.vsb.ekf.lan0116.events;


public enum EquipFailure implements FailureCause {
    ;

    @Override
    public EventType getEventType() {
        return EventType.EQUIP;
    }
}
