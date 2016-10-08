package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.textUi.locationUi.LocationUi;

public class TextEvents {

    private final Context context;

    public TextEvents(Context context) {
        this.context = context;
    }

    public void playGame() {
        context.getEventHandler().handleEvent(new Event(EventType.NEW_GAME));
        System.out.println(this.context.getLocalization().get("textUi.textEvents.flee") + "\n\n");
        LocationUi locUi = new LocationUi(context);
        while (true) {
            locUi.show();
        }
    }
}
