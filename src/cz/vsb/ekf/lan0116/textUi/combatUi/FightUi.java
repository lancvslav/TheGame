package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyDeprecated;

public class FightUi extends AbstractLocationUi {

    private Hero hero;
    private EnemyDeprecated enemyDeprecated;
    private Tournament tournament;
    private TournamentUi tournamentUi;
    private CreatureStatusUi creatureStatusUi;


   public FightUi(Context context, Creature hero, Creature enemy, Tournament tournament) {
        super(context);
        this.hero = (Hero) hero;
        this.enemyDeprecated = (EnemyDeprecated) enemy;
        this.tournament = tournament;
    }

    @Override
    public void show() {
//        while (heroHandling.isAlive() && enemyDeprecated.isAlive()) {
//            Fight combat = new Fight(heroHandling, enemyDeprecated);
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new DamageInflictionEvent(enemyDeprecated, combat.attacking(heroHandling, enemyDeprecated)));
//            System.out.println("You hit with " +
//                    this.get(heroHandling.getWeaponObject().getName()) + " for: " + combat.attacking(heroHandling, enemyDeprecated));
//            TextUtil.sleep(90);
//            if (!enemyDeprecated.isAlive()) {
//                System.out.println("EnemyDeprecated died.");
//                TextUtil.sleep(50);
//                return;
//            }
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new DamageInflictionEvent(heroHandling, combat.attacking(enemyDeprecated, heroHandling)));
//            TextUtil.sleep(90);
//            System.out.println("EnemyDeprecated hit for " + combat.attacking(enemyDeprecated, heroHandling) +
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
