package cz.vsb.ekf.lan0116.eventsHandling.events;

public class NewGameEvent implements EventTypeInterface {

    @Override
    public EventSuperType getEventSuperType() {
        return EventSuperType.GAME_EVENT;
    }
}
