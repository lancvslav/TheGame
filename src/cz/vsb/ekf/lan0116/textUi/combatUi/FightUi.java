package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FleeEvent;
import cz.vsb.ekf.lan0116.eventSystem.failures.CombatFailure;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.textUi.heroUi.InventoryUi;

public class FightUi extends AbstractLocationUi {

    public FightUi(Context context) {
        super(context);
    }

    /**
     * Prints current enemy
     */
    @Override
    public void show() {
        System.out.println(this.get("textUi.FightUi.facing") + " "
                + this.get(this.getContext().getHero().getHeroInteraction().getCurrentEnemy().getName()));
        this.decisions();
    }

    /**
     * Prints choices attacks, inventory, try to flee
     */
    @Override
    public void decisions() {
        switch (this.choice(this.get("textUi.FightUi.attacks"),
                this.get("textUi.FightUi.inventory"),
                this.get("textUi.FightUi.try_flee"))) {
            case 0:
                new AttacksUi(this.getContext()).show();
                break;
            case 1:
                new InventoryUi(this.getContext()).show();
                break;
            case 2:
                Response response = this.getContext().getSession().fireEvent(new FleeEvent());
                if (response.isSuccess()) {
                    System.out.println(this.get(TextUtil.quote("flee")));
                    this.travel();
                } else {
                    CombatFailure fleeFailure = (CombatFailure) response.getFailureCause();
                    switch (fleeFailure) {
                        case FLEE_DISABLED:
                            System.out.println(this.get(TextUtil.quote("flee_disabled")));
                            break;
                        case FLEE_WEAK:
                            System.out.println(this.get(TextUtil.quote("flee_weak")));
                            break;
                    }
                }
                break;
            default: //enemy attacks without questions, but how?
        }
    }
}
