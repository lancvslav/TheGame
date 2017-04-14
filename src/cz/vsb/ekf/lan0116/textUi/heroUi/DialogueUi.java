package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.StopTalkingEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping.InitiateDialogueEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractCreatureUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

public class DialogueUi extends AbstractCreatureUi {
    protected DialogueUi(Creature creature, Context context) {
        super(creature, context);
    }

    /**
     * prints Name of npc player is talking to
     */
    @Override
    public void show() {
        System.out.println(this.get(this.getCreature().getName()));

        this.talking();
    }

    /**
     * this method prints talking
     */
    private void talking() {
        this.getContext().getSession().fireEvent(new InitiateDialogueEvent((Humanoid) this.getCreature()));
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
                this.talking();
                break;
            case 1:
                this.getContext().getSession().fireEvent(new StopTalkingEvent((Humanoid) this.getCreature()));
                break;
        }
    }
}
