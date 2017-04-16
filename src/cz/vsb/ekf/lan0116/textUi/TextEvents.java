package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.game.NewGameEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.*;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.game.GameOverResponse;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech.FriendlySpeech;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech.NeutralSpeech;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech.SpeechLogServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.speech.SpeechResponse;
import cz.vsb.ekf.lan0116.textUi.combatUi.FightUi;
import cz.vsb.ekf.lan0116.textUi.combatUi.TournamentUi;
import cz.vsb.ekf.lan0116.textUi.heroUi.DialogueUi;
import cz.vsb.ekf.lan0116.textUi.heroUi.RestHeroUi;
import cz.vsb.ekf.lan0116.textUi.locationUi.InteractUi;
import cz.vsb.ekf.lan0116.textUi.locationUi.LocationUi;
import cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi.MerchandiseUi;

import java.util.List;

public class TextEvents {

    private final Context context;

    public TextEvents(Context context) {
        this.context = context;
    }

    /**
     * This method's job is printing the whole game. (Poor method). First of all, it starts the game by firing an event,
     * after that, it prints first milestone - LocationUi, which prints screen offering to player choices to take.
     * Then it checks, whether some serverEvent occurred,
     * if so, it prints the outcome by invoking @printFightResponse, then it invokes Ui which prints screen related to
     * current HeroStatus.
     */
    public void playGame() {
        Response responseNewGame = context.getSession().fireEvent(new NewGameEvent());
        if (!responseNewGame.isSuccess()) {
            System.out.println(this.get("textUi.textEvents.failed"));
            throw new ExceptionInInitializerError();
        }
        System.out.println(this.get("textUi.textEvents.flee"));

        LocationUi locUi = new LocationUi(context);

        while (true) {
            ServerEvent serverEvent;
            while ((serverEvent = context.getSession().getResponses().poll()) != null) {
                if (serverEvent.getType() == ServerEvent.ServerEventType.GAME_OVER) {
                    System.out.println(this.get("textUi.textEvents.game_over") + " "
                            + ((GameOverResponse) serverEvent).getReason());
                    return;
                }
                //pulling battle log in case that battle happened
                if (serverEvent.getType() == ServerEvent.ServerEventType.BATTLE_LOG) {
                    BattleLogServerEvent eventLog = (BattleLogServerEvent) serverEvent;
                    List<FightResponse> battleLog = eventLog.getBattleLog();
                    for (FightResponse response : battleLog) {
                        this.printFightResponse(response);
                    }
                }
                //pulling speech log in case speech happened
                if (serverEvent.getType() == ServerEvent.ServerEventType.SPEECH) {
                    SpeechLogServerEvent eventLog = (SpeechLogServerEvent) serverEvent;
                    List<SpeechResponse> speechLog = eventLog.getSpeechLog();
                    for (SpeechResponse response : speechLog) {
                        this.printSpeechResponse(response);
                    }
                }
            }
            switch (context.getHero().getHeroInteraction().getStatus()) {
                case IN_COMBAT:
                    new FightUi(context).show();
                    break;
                case INTERACTING:
                    new InteractUi(context).show();
                    break;
                case IN_TOURNAMENT:
                    new TournamentUi(context).show();
                    break;
                case READY:
                    locUi.show();
                    break;
                case RESTING:
                    new RestHeroUi(context).show();
                    break;
                case SHOPPING:
                    new MerchandiseUi(context).show();
                    break;
                case TALKING:
                    new DialogueUi(context).show();
                    break;
                default:
                    throw new UnsupportedOperationException("screen for " + context.getHero().getHeroInteraction().getStatus()
                            + " not implemented yet");
            }
        }
    }


    /**
     * prints an outcome of server events that implements FightResponse
     */
    private void printFightResponse(FightResponse response) {
        switch (response.getType()) {
            case DAMAGE_INFLICTION:
                DamageInfliction damageInfliction = (DamageInfliction) response;
                Attack attack = damageInfliction.getAttack();
                String attackString = "";
                if (attack != null) {
                    attackString = this.get(attack.getName());
                }
                String attacker = this.get(damageInfliction.getAttacker().getName());
                String defender = this.get(damageInfliction.getDefender().getName());
                float damage = damageInfliction.getDamageDealt();
                if (attack != null) {
                    System.out.println(attacker + " " + this.get("textUi.textEvents.used") + " " + attackString + " "
                            + this.get("textUi.textEvents.to_attack"));
                }
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
                String consumer = this.get(consumption.getStaminaUser().getName());
                float consumed = consumption.getStaminaDecrease();
                System.out.println(consumer + " " + this.get("textUi.textEvents.used")
                        + " " + consumed + " " + this.get("textUi.textEvents.stamina"));
                break;
//            case YOU_DIED:
//                System.out.println(this.get("textUi.textEvents.YOU_DIED"));
//                break;
        }
    }

    /**
     * prints an outcome of server events that implements SpeechResponse
     */
    private void printSpeechResponse(SpeechResponse response) {
        switch (response.getType()) {
            case FRIENDLY:
                FriendlySpeech friendlySpeech = (FriendlySpeech) response;
                this.talk(friendlySpeech.getSpeech());
                break;
            case NEUTRAL:
                NeutralSpeech neutralSpeech = (NeutralSpeech) response;
                this.talk(neutralSpeech.getSpeech());
                break;
        }
    }

    private String get(String key) {
        return context.getLocalization().get(key);
    }

    /**
     * Prints dialogue with delays between letters, so it appears that someone is actually talking
     */
    public void talk(String dialogue) {
        for (int i = 0, folder = 0; i < dialogue.length(); i++, folder++) {
            System.out.print(dialogue.charAt(i));
            TextUtil.sleep(80);
            if (folder == 78) {
                System.out.print("-\n");
                folder = 0;
            }
        }
        System.out.println();
    }
}
