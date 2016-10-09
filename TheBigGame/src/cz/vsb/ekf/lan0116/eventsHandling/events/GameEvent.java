package cz.vsb.ekf.lan0116.eventsHandling.events;

public enum GameEvent implements Event{

    ;


    @Override
    public EventType getType() {
        return EventType.GAME_EVENT;
    }

    @Override
    public Class getResponseType() {
        return null;
    }
}
