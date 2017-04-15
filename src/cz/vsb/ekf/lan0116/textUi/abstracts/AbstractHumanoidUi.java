package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;

public abstract class AbstractHumanoidUi extends AbstractUi {


    protected AbstractHumanoidUi(Context context) {
        super(context);
    }

    /**
     * internal call: this.getContext().getHero().getHeroInteraction().getSubjectOfInteraction();
     */
    public Humanoid getHumanoid() {
        return this.getContext().getHero().getHeroInteraction().getSubjectOfInteraction();
    }
}
