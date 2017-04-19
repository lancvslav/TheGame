package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.StopTalkingEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping.InitiateDialogueEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHumanoidUi;

public class DialogueUi extends AbstractHumanoidUi {
    public DialogueUi(Context context) {
        super(context);
    }

    /**
     * prints Name of npc player is talking to
     */
    @Override
    public void show() {
        System.out.println(this.get(this.getHumanoid().getName()));
        this.decisions();
    }

    /**
     * prints choices: talk more, stop talking
     */
    @Override
    protected void decisions() {
        switch (this.choice(this.get("textUi.DialogueUi.talk_more"),
                this.get("textUi.DialogueUi.stop_talking"))) {
            case 0:
                this.getContext().getSession().fireEvent(new InitiateDialogueEvent(this.getHumanoid()));
                break;
            case 1:
                this.getContext().getSession().fireEvent(new StopTalkingEvent(this.getHumanoid()));
                break;
        }
    }
}
