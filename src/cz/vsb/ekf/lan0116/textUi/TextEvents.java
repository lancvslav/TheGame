package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.game.NewGameEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.*;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.game.GameOverResponse;
import cz.vsb.ekf.lan0116.textUi.combatUi.FightUi;
import cz.vsb.ekf.lan0116.textUi.heroUi.RestHeroUi;
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
            System.out.println(this.get("textUi.textEvents.failed"));
            throw new ExceptionInInitializerError();
        }
        System.out.println(this.get("textUi.textEvents.flee") + "\n\n");

        LocationUi locUi = new LocationUi(context);

        while (true) {
            ServerEvent serverEvent;
            while ((serverEvent = context.getSession().getResponses().poll()) != null) {
                if (serverEvent.getType() == ServerEvent.ServerEventType.GAME_OVER) {
                    System.out.println(this.get("textUi.textEvents.game_over") + " "
                            + ((GameOverResponse) serverEvent).getReason());
                    return;
                }
                if (serverEvent.getType() == ServerEvent.ServerEventType.BATTLE_LOG) {
                    BattleLogServerEvent event = (BattleLogServerEvent) serverEvent;
                    List<FightResponse> battleLog = event.getBattleLog();
                    for (FightResponse response : battleLog) {
                        this.printResponse(response);
                    }
                }
            }
            switch (context.getHero().getHeroInteraction().getStatus()) {
                case READY:
                    locUi.show();
                    break;
                case IN_COMBAT:
                    new FightUi(context).show();
                    break;
                case RESTING:
                    new RestHeroUi(context).show();
                    break;
                case SHOPPING:
                    // shopping?
                    break;
                default:
                    // fail? do nothing?
            }
        }
    }

    private void printResponse(FightResponse response) {
        switch (response.getType()) {
            case DAMAGE_INFLICTION:
                DamageInfliction damageInfliction = (DamageInfliction) response;
                String attacker = this.get(damageInfliction.getAttacker().getName());
                String defender = this.get(damageInfliction.getDefender().getName());
                float damage = damageInfliction.getDamageDealt();
                System.out.println(attacker + " " + this.get("textUi.textEvents.dealt") + " " + damage
                        + " " + this.get("textUi.textEvents.damage_to") + " " + defender);
                break;
            case HEALING:
                Healing healing = (Healing) response;
                String healedOne = this.get(healing.getCreature().getName());
                float healed = healing.getHealed();
                System.out.println(healedOne + " "
                        + this.get("textUi.textEvents.healed") + " " + healed);
                break;
            case INFORMATION:
                Information information = (Information) response;
                switch (information.getMessage()) {
                    case DEATH:
                        System.out.println(this.get(information.getSubject().getName()) + " "
                                + this.get("textUi.textEvents.died"));
                        break;
                    case INSUFFICIENT_STAMINA:
                        System.out.println(this.get(information.getSubject().getName())
                                + " " + this.get("textUi.textEvents.not_enough_stamina"));
                        break;
                }
                break;
            case STAMINA_CONSUMPTION:
                StaminaConsumption consumption = (StaminaConsumption) response;
                String consumer = consumption.getStaminaUser().getName();
                float consumed = consumption.getStaminaDecrease();
                System.out.println(consumer + " " + this.get("textUi.textEvents.used")
                        + " " + consumed + " " + this.get("textUi.textEvents.stamina"));
                break;
//            case YOU_DIED:
//                System.out.println(this.get("textUi.textEvents.YOU_DIED"));
//                break;
        }
    }

    private String get(String key) {
        return context.getLocalization().get(key);
    }
}
