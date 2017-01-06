package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.game.NewGameEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.*;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.game.GameOverResponse;
import cz.vsb.ekf.lan0116.textUi.combatUi.FightUi;
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
        FightUi fightUi;

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
                        switch (response.getType()) {
                            case DAMAGE_INFLICTION:
                                DamageInfliction damageInfliction = (DamageInfliction) response;
                                String attacker = damageInfliction.getAttacker().getName();
                                String defender = damageInfliction.getDefender().getName();
                                float damage = damageInfliction.getDamageDealt();
                                System.out.println(attacker + " dealt " + damage + " damage to " + defender);
                                break;
                            case HEALING:
                                Healing healing = (Healing) response;
                                String healedOne = healing.getCreature().getName();
                                float healed = healing.getHealed();
                                System.out.println(healedOne + " was healed for " + healed);
                                break;
                            case STAMINA_CONSUMPTION:
                                StaminaConsumption consumption = (StaminaConsumption) response;
                                String consumer = consumption.getStaminaUser().getName();
                                float consumed = consumption.getStaminaDecrease();
                                System.out.println(consumer + " used " + consumed + " stamina");
                        }
                    }
                }
            }
            switch (context.getHero().getHeroInteraction().getStatus()) {
                case READY:
                    locUi.show();
                    break;
                case IN_COMBAT:
                    fightUi = new FightUi(context, context.getHero(),
                            context.getHero().getHeroInteraction().getCurrentEnemy());
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
