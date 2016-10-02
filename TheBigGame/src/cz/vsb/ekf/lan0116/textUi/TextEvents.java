package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.events.Event;
import cz.vsb.ekf.lan0116.events.EventType;

public class TextEvents {

    private final Context context;

    public TextEvents(Context context) {
        this.context = context;
    }

    public void playGame() {
        context.getEventHandler().handleEvent(new Event(EventType.NEW_GAME));
        System.out.printf("%s\n%n", this.context.getLocalization().get("textUi.textEvents.flee"));
        LocationUi locUi = new LocationUi(context);
        while (true) {
            locUi.show();
        }
    }
}