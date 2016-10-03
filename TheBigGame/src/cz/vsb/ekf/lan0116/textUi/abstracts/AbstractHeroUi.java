package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public abstract class AbstractHeroUi extends AbstractUi {

    protected AbstractHeroUi(Context context) {
        super(context);
    }

    public Hero getHero() {
        return this.getContext().getHero();
    }

}
