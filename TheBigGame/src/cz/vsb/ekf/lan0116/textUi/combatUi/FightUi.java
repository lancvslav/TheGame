package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Fight;
import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.eventsHandling.events.InflictDamageEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextUtil;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.wilderness.Enemy;

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
        while (hero.isAlive() && enemy.isAlive()) {
            Fight fight = new Fight(hero, enemy);

            this.getContext().getChannelGame().
                    handleEvent(new InflictDamageEvent(enemy, fight.attacking(hero, enemy)));
            System.out.println("You hit with " +
                    this.get(hero.getWeapon().getName()) + " for: " + fight.attacking(hero, enemy));
            TextUtil.sleep(90);
            if (!enemy.isAlive()) {
                System.out.println("Enemy died.");
                TextUtil.sleep(50);
                return;
            }

            this.getContext().getChannelGame().
                    handleEvent(new InflictDamageEvent(hero, fight.attacking(enemy, hero)));
            TextUtil.sleep(90);
            System.out.println("Enemy hit for " + fight.attacking(enemy, hero) +
                    " dmg. Your life essence status: " + hero.getCurrentHp());
            new CreatureStatusUi(this.getContext(), hero).show();
            TextUtil.sleep(20);
        }

        if (!hero.isAlive()) {
            TextUtil.sleep(90);
            System.out.println("You died");
        }
    }
}
