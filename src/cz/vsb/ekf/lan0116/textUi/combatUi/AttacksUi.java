package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHeroUi;
import cz.vsb.ekf.lan0116.world.creature.hero.HeroInteraction;

public class AttacksUi extends AbstractHeroUi {

    private String[] attacks;

    protected AttacksUi(Context context) {
        super(context);
        attacks = new String[this.getHero().getAttacks().size()];
        for (int i = 0; i < attacks.length; i++) {
            attacks[i] = this.getContext().getHero().getAttacks().get(i).getName();
        }
    }

    @Override
    public void show() {
        System.out.println("Attacks showtime");
        this.printArray(attacks);
        if (this.getHero().getHeroInteraction().getStatus().equals(HeroInteraction.HeroStatus.IN_COMBAT)) {
            switch (this.choice("select", "close")) {
                case 0:

                    break;
                case 1:
                    break;
            }
        }
        int index = this.choice(attacks);
        Attack attack = this.getHero().getAttacks().get(index);
    }

    private Attack getAttack() {
        return null;//null
    }
}
