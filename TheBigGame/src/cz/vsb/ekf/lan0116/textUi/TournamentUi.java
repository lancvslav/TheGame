package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.events.Event;
import cz.vsb.ekf.lan0116.events.EventType;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.wilderness.Enemy;

class TournamentUi extends AbstractLocationUi {

    private Hero hero;
    private Tournament tournament;
    private FightUi fightUi;
    private ArenaUi arenaUi;
    private Enemy currentEnemy;

    TournamentUi(Context context, Tournament tournament) {
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
            System.out.printf("\nNext enemy: %s%n", this.get(currentEnemy.getName()));
            switch (this.choice("Flee", "Proceed")) {
                case 0:
                    System.out.println("\nYou coward!");
                    this.travel();
                    return;
            }
            System.out.println();
            fightUi = new FightUi(this.getContext(), hero, currentEnemy, tournament);
            fightUi.show();
        }
        if (!hero.isAlive()) {
            this.getContext().getEventHandler().handleEvent(new Event(EventType.RESPAWN));
            return;
        }
        System.out.println("You won.");
        arenaUi = new ArenaUi(this.getContext());
        arenaUi.show();


//        while (hero.isAlive()) {
//            for (int enemyId = 0; enemyId < tournament.getEnemyList().size(); enemyId++) {
//                if (!hero.isAlive()) {
//                    break;
//                }
//                currentEnemy = tournament.getEnemyList().get(enemyId);
//                System.out.printf("\nNext enemy: %s%n", this.get(currentEnemy.getName()));
//                switch (this.choice("Flee", "Proceed")) {
//                    case 0:
//                        System.out.println("\nYou coward!");
//                        this.travel();
//                        return;
//                }
//                System.out.println();
//                fightUi = new FightUi(this.getContext(), hero, currentEnemy, tournament);
//                fightUi.show();
//            }
//        }
//        this.getContext().getEventHandler().handleEvent(new Event(EventType.RESPAWN));
    }
}
