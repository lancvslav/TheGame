package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHeroUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class CreatureStatusUi extends AbstractHeroUi {

    private Creature creature;

    public CreatureStatusUi(Context context, Creature creature) {
        super(context);
        this.creature = creature;
    }

    @Override
    public void show() {
        System.out.println();
    }


    @Override
    protected void decisions() {
    }
}
