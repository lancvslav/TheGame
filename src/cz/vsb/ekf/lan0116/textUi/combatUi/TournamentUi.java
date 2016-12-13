package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.eventSystem.events.game.RespawnEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyDeprecated;

public class TournamentUi extends AbstractLocationUi {

    private Hero hero;
    private Tournament tournament;
    private FightUi fightUi;
    private ArenaUi arenaUi;
    private EnemyDeprecated currentEnemyDeprecated;

    public TournamentUi(Context context, Tournament tournament) {
        super(context);
        hero = context.getHero();
        this.tournament = tournament;

    }

    @Override
    public void show() {
        for (int enemyId = 0; enemyId < tournament.getEnemyDeprecatedList().size(); enemyId++) {
            if (!hero.isAlive()) {
                break;
            }
            currentEnemyDeprecated = tournament.getEnemyDeprecatedList().get(enemyId);
            System.out.println("\n" + this.get("textUi.TournamentUi.next") + " " + this.get(currentEnemyDeprecated.getName()));
            switch (this.choice(
                    this.get("texUi.TournamentUi.flee"),
                    this.get("texUi.TournamentUi.proceed"))) {
                case 0:
                    System.out.println("\n" + this.get("texUi.TournamentUi.coward"));
                    this.travel();
                    return;
            }
            System.out.println();
            fightUi = new FightUi(this.getContext(), hero, currentEnemyDeprecated, tournament);
            fightUi.show();
        }
        if (!hero.isAlive()) {
            this.getContext().getEventPublisher().getResponse(new RespawnEvent());
            return;
        }
        System.out.println(this.get("texUi.TournamentUi.won"));
        arenaUi = new ArenaUi(this.getContext());
        arenaUi.show();
    }

    @Override
    public void decisions() {

    }
}
