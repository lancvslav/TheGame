package cz.vsb.ekf.lan0116.eventsHandling.events;

public interface Event {

    EventType getType();

    default EventSuperType getSuperType() {
        return getType().getEventSuperType();
    }

}
