package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.eventsHandling.events.Event;
import cz.vsb.ekf.lan0116.eventsHandling.events.EventType;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.wilderness.Enemy;

public class TournamentUi extends AbstractLocationUi {

    private Hero hero;
    private Tournament tournament;
    private FightUi fightUi;
    private ArenaUi arenaUi;
    private Enemy currentEnemy;

    public TournamentUi(Context context, Tournament tournament) {
        super(context);
        hero = context.getHero();
        this.tournament = tournament;

    }

    @Override
    public void show() {

        for (int enemyId = 0; enemyId < tournament.getEnemyList().size(); enemyId++) {
            if (!hero.isAlive()) {
                break;
            }
            currentEnemy = tournament.getEnemyList().get(enemyId);
            System.out.println("\n" + this.get("textUi.TournamentUi.next") + " " + this.get(currentEnemy.getName()));
            switch (this.choice(
                    this.get("texUi.TournamentUi.flee"),
                    this.get("texUi.TournamentUi.proceed"))) {
                case 0:
                    System.out.println("\n" + this.get("texUi.TournamentUi.coward"));
                    this.travel();
                    return;
            }
            System.out.println();
            fightUi = new FightUi(this.getContext(), hero, currentEnemy, tournament);
            fightUi.show();
        }
        if (!hero.isAlive()) {
            this.getContext().getChannelGame().handleEvent(new Event(EventType.RESPAWN));
            return;
        }
        System.out.println(this.get("texUi.TournamentUi.won"));
        arenaUi = new ArenaUi(this.getContext());
        arenaUi.show();
    }
}
