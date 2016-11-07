package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.game.NewGameEvent;
import cz.vsb.ekf.lan0116.textUi.locationUi.LocationUi;

public class TextEvents {

    private final Context context;

    public TextEvents(Context context) {
        this.context = context;
    }

    public void playGame() {
        Response responseNewGame = context.getEventPublisher().getResponse(new NewGameEvent());
        if (!responseNewGame.isSuccess()) {
            System.out.println("Failed to load game.");
            throw new ExceptionInInitializerError();
        }
        System.out.println(this.context.getLocalization().get("textUi.textEvents.flee") + "\n\n");
        LocationUi locUi = new LocationUi(context);
        while (true) {
            locUi.show();
        }
    }
}
