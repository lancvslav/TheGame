package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public abstract class AbstractCreatureUi extends AbstractUi {

    private Creature creature;

    protected AbstractCreatureUi(Creature creature, Context context) {
        super(context);
    }

    public Creature getCreature() {
        return creature;
    }
}
