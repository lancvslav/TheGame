package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.eventSystem.events.combat.ProceedEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.game.RespawnEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class TournamentUi extends AbstractLocationUi {

    private Hero hero;
    private Creature currentEnemy;

    public TournamentUi(Context context) {
        super(context);
        hero = context.getHero();
    }

    @Override
    public void show() {
        currentEnemy = this.getContext().getHero().getHeroInteraction().getCurrentEnemy();
        if (currentEnemy == null) {
            System.out.println("won");
            return;
        }
        System.out.println("\n" + this.get("textUi.TournamentUi.next") + " " + this.get(currentEnemy.getName()));
        switch (this.choice(
                this.get("texUi.TournamentUi.pussy_out"),
                this.get("texUi.TournamentUi.proceed"))) {
            case 0:
                System.out.println("\n" + this.get("texUi.TournamentUi.coward"));
                System.out.println(this.get("textUi.StreetUi.paths") + ":");
                for (int i = 0; i < this.getLoc().getGateways().size(); i++) {
                    System.out.println(this.get(this.getLoc().getGateways().get(i).getTarget().getName()));
                }
                return;
            case 1:
                System.out.println();
                this.getContext().getSession().fireEvent(new ProceedEvent());
                return;
        }
        if (!hero.isAlive()) {
            this.getContext().getSession().fireEvent(new RespawnEvent());
        }
    }

    @Override
    public void decisions() {
    }
}
