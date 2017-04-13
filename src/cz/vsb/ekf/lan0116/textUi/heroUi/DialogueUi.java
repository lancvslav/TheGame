package cz.vsb.ekf.lan0116.textUi.heroUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractCreatureUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class DialogueUi extends AbstractCreatureUi {
    protected DialogueUi(Creature creature, Context context) {
        super(creature, context);
    }

    @Override
    public void show() {
        System.out.println(this.get(this.getCreature().getName()));

        this.decisions();
    }

    /**
     * prints choices: talk more, stop talking
     */
    @Override
    protected void decisions() {
        switch (this.choice(this.get("talk more"),
                this.get("stop talking"))) {
            case 0:
                break;
            case 1:
                break;
        }
    }
}
