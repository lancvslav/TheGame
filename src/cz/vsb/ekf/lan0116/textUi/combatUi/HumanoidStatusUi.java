package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHeroUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;

/**
 * not implemented yet
 */
public class HumanoidStatusUi extends AbstractHeroUi {

    private Creature creature;

    public HumanoidStatusUi(Context context, Creature creature) {
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
