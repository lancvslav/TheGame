package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.game.NewGameEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.BattleLogServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.FightResponse;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.game.GameOverResponse;
import cz.vsb.ekf.lan0116.textUi.locationUi.LocationUi;

import java.util.List;

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
            ServerEvent serverEvent;
            while ((serverEvent = context.getSession().getResponses().poll()) != null) {
                if (serverEvent.getType() == ServerEvent.ServerEventType.GAME_OVER) {
                    System.out.println("Game is over, because " + ((GameOverResponse) serverEvent).getReason());
                    return;
                }
                if (serverEvent.getType() == ServerEvent.ServerEventType.BATTLE_LOG) {
                    BattleLogServerEvent event = (BattleLogServerEvent) serverEvent;
                    List<FightResponse> battleLog = event.getBattleLog();
                    for (FightResponse response : battleLog) {
                        switch(response.getType()){
                            //finish me please please me
                        }
                    }
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
