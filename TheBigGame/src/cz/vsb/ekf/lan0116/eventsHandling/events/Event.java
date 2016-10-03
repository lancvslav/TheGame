package cz.vsb.ekf.lan0116.eventsHandling.events;

public class Event {

    private EventType type;

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

}
