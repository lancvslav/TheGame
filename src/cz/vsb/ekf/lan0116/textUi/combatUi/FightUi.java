package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;

public class FightUi extends AbstractLocationUi {

    private Hero hero;
    private Enemy enemy;
    private Tournament tournament;
    private TournamentUi tournamentUi;
    private CreatureStatusUi creatureStatusUi;


   public FightUi(Context context, Creature hero, Creature enemy, Tournament tournament) {
        super(context);
        this.hero = (Hero) hero;
        this.enemy = (Enemy) enemy;
        this.tournament = tournament;
    }

    @Override
    public void show() {
//        while (heroHandling.isAlive() && enemy.isAlive()) {
//            Fight combat = new Fight(heroHandling, enemy);
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new DamageInflictionEvent(enemy, combat.attacking(heroHandling, enemy)));
//            System.out.println("You hit with " +
//                    this.get(heroHandling.getWeapon().getName()) + " for: " + combat.attacking(heroHandling, enemy));
//            TextUtil.sleep(90);
//            if (!enemy.isAlive()) {
//                System.out.println("Enemy died.");
//                TextUtil.sleep(50);
//                return;
//            }
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new DamageInflictionEvent(heroHandling, combat.attacking(enemy, heroHandling)));
//            TextUtil.sleep(90);
//            System.out.println("Enemy hit for " + combat.attacking(enemy, heroHandling) +
//                    " dmg. Your life essence status: " + heroHandling.getCurrentLifeEssence());
//            new CreatureStatusUi(this.getContext(), heroHandling).show();
//            TextUtil.sleep(20);
//        }
//
//        if (!heroHandling.isAlive()) {
//            TextUtil.sleep(90);
//            System.out.println("You died");
//        }
    }

    @Override
    public void decisions() {

    }
}
