package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

abstract class AbstractHeroUi extends AbstractUi {

    AbstractHeroUi(Context context) {
        super(context);
    }

    public Hero getHero() {
        return this.getContext().getHero();
    }

}
