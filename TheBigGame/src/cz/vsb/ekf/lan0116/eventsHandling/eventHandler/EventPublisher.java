package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventTypeInterface;

public class EventPublisher {

    public void channelize(EventTypeInterface event){
        switch (event.getEventSuperType()){
            case FIGHT_EVENT:break;
            case GAME_EVENT:break;
            case HERO_EVENT:;break;
            default:
                throw new UnsupportedOperationException("Channel " + event.getEventSuperType() + " is not supported.");
        }

    }
}
