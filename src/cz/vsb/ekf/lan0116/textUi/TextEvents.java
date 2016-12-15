package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.game.NewGameEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.game.GameOverResponse;
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
            ServerEvent event;
            while ((event = context.getSession().getResponses().poll()) != null) {
                if (event.getType() == ServerEvent.ServerEventType.GAME_OVER) {
                    System.out.println("Game is over, because " + ((GameOverResponse) event).getReason());
                    return;
                } if (event.getType() == ServerEvent.ServerEventType.ATTACK_MOVE_SUMMARY) {
                    // show summary
                }
            }
            switch (context.getHero().getHeroInteraction().getStatus()) {
                case READY:
                    locUi.show();
                    break;
                case IN_COMBAT:
                    // fightUi?
                    break;
                case RESTING:
                    // restUi?
                    break;
                case SHOPPING:
                    // shopping?
                    break;
                default:
                    // fail? do nothing?
            }
        }
    }
}
