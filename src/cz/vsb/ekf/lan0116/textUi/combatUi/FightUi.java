package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class FightUi extends AbstractLocationUi {

    private Hero hero;
    private Creature enemy;
    private CreatureStatusUi creatureStatusUi;


    public FightUi(Context context, Creature hero, Creature enemy) {
        super(context);
        this.hero = (Hero) hero;
        this.enemy = enemy;
    }

    @Override
    public void show() {
        System.out.println("You are facing " + this.getContext().getHero().getHeroInteraction().getCurrentEnemy());
        switch (this.choice("attacks", "inventory", "try to flee")) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default: //enemy attacks without questions
        }
    }

    @Override
    public void decisions() {

    }
}
