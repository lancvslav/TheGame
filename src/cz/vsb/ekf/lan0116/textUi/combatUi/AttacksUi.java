package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.AttackMoveEvent;
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
        this.printArray(attacks);
        System.out.println();
        if (this.getHero().getHeroInteraction().getStatus().equals(HeroInteraction.HeroStatus.IN_COMBAT)) {
            switch (this.choice(this.get("textUi.AttacksUi.select"),
                    this.get("textUi.AttacksUi.close"))) {
                case 0:
                    System.out.println(this.get("textUi.AttacksUi.choose"));
                    String tempString = this.getContext().getScanner().nextLine();
                    int tempChoiceNumber = Integer.parseInt(tempString);
                    Attack attack = this.getHero().getAttacks().get(tempChoiceNumber);
                    Response response = this.getContext().getEventPublisher().getResponse(new AttackMoveEvent(attack));
                    break;
                case 1:
                    new FightUi(this.getContext()).decisions();
            }
        }
    }
}
