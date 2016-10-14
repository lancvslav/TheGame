package cz.vsb.ekf.lan0116.eventsHandling.failures;

import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;

public interface FailureCause {
    EventType getEventType();
}
