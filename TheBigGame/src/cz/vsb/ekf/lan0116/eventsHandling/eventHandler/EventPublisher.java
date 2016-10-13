package cz.vsb.ekf.lan0116.eventsHandling.eventHandler;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public class EventPublisher {

    public void channelize(EventType event){
        switch (event.getEventSuperType()){
            case COMBAT:break;
            case GAME:break;
            case HERO:break;
            default:
                throw new UnsupportedOperationException("Channel " + event.getEventSuperType() + " is not supported.");
        }

    }
}
