package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.combat.Fight;
import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.eventsHandling.events.InflictDamageEvent;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.wilderness.Enemy;

class FightUi extends AbstractLocationUi {

    private Hero hero;
    private Enemy enemy;
    private Tournament tournament;
    private TournamentUi tournamentUi;
    private CreatureStatusUi creatureStatusUi;


    FightUi(Context context, Creature hero, Creature enemy, Tournament tournament) {
        super(context);
        this.hero = (Hero) hero;
        this.enemy = (Enemy) enemy;
        this.tournament = tournament;
    }

    @Override
    public void show() {
        while (hero.isAlive() && enemy.isAlive()) {
            Fight fight = new Fight(hero, enemy);

            this.getContext().getEventHandler().
                    handleEvent(new InflictDamageEvent(enemy, fight.attacking(hero, enemy)));
            System.out.println("You hit with " +
                    this.get(hero.getWeapon().getName()) + " for: " + fight.attacking(hero, enemy));
            sleep(90);
            if (!enemy.isAlive()) {
                System.out.println("Enemy died.");
                sleep(50);
                return;
            }

            this.getContext().getEventHandler().
                    handleEvent(new InflictDamageEvent(hero, fight.attacking(enemy, hero)));
            sleep(90);
            System.out.println("Enemy hit for " + fight.attacking(enemy, hero) +
                    " dmg. Your life essence status: " + hero.getCurrentHp());
            new CreatureStatusUi(this.getContext(), hero).show();
            sleep(20);
        }

        if (!hero.isAlive()) {
            sleep(90);
            System.out.println("You died");
        }
    }
}
