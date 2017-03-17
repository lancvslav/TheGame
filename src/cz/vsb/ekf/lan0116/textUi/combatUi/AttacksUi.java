package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.AttackMoveEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.game.RespawnEvent;
import cz.vsb.ekf.lan0116.eventSystem.failures.CombatFailure;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractHeroUi;

import java.util.List;

public class AttacksUi extends AbstractHeroUi {

    private List<Attack> attacks;

    protected AttacksUi(Context context) {
        super(context);
        attacks = this.getHero().getAttacks();
    }


    @Override
    public void show() {
        System.out.println(this.get("textUi.AttacksUi.choose") + ":");
        this.printArray(attacksToArray(attacks));
        System.out.printf("%d %s%n", attacks.size(), this.get("textUi.AttacksUi.close"));
        this.decisions();
    }

    @Override
    protected void decisions() {
        int choice = Integer.parseInt(this.getContext().getScanner().nextLine());
        if (choice >= (attacks.size())) {
            return;
        } else {
            Attack attack = this.getHero().getAttacks().get(choice);
            Response response = this.getContext().getSession().fireEvent(new AttackMoveEvent(attack));
            if (response.getFailureCause() != null) {
                if (response.getFailureCause().equals(CombatFailure.YOU_DIED)) {
                    this.getContext().getSession().fireEvent(new RespawnEvent());
                    return;
                }
            }
        }
    }
}
