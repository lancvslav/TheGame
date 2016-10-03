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
        System.out.println(lifeIndicator());
    }

    public String lifeIndicator() {
        StringBuffer sBuff = new StringBuffer();
        sBuff.append("[");

        int total = 20;
        double count = Math.round(((double) this.getHero().getCurrentHp() / this.getHero().getMaxHp()) * total);
        if ((count < 1) && (creature.isAlive())) {
            count = 1;
        }
        for (int i = 0; i < count; i++) {
            sBuff.append("#");
        }
        for (int i = 0; i < total - count; i++) {
            sBuff.append("_");
        }
        sBuff.append("]");
        return sBuff.toString();
    }

}
