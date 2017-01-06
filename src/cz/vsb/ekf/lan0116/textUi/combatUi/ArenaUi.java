package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.location.building.Arena;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;

import java.util.LinkedList;
import java.util.Queue;

public class ArenaUi extends AbstractLocationUi {

    private TournamentUi tournamentUi;

    public ArenaUi(Context context) {
        super(context);
    }

    @Override
    public Arena getLoc() {
        return (Arena) this.getContext().getHero().getHeroInteraction().getPosition();
    }

    @Override
    public void show() {
        System.out.println("\n" + this.get("textUi.ArenaUi.welcome"));
        System.out.println(this.get("textUi.ArenaUi.tournament_selection"));
        this.decisions();
    }

    @Override
    public void decisions() {
        switch (this.choice(
                this.get("textUi.ArenaUi.back"),
                this.get("textUi.ArenaUi.sign_up"))) {
            case 0:
                this.travel();
                break;
            case 1:
                System.out.println("\n" + this.get("textUi.ArenaUi.entered_tournament"));
                Queue<Creature> enemyQueue;
                switch (this.choice(
                        this.get("textUi.ArenaUi.tournament0"),
                        this.get("textUi.ArenaUi.tournament1"),
                        this.get("textUi.ArenaUi.tournament2"))) {
                    case 0:
                        tournamentUi = new TournamentUi(this.getContext(), this.getLoc().getTournaments().get(0));
                        enemyQueue = new LinkedList<>(this.getLoc().getTournaments()
                                .get(0).getEnemyList());
                        this.getContext().getHero().getHeroInteraction().setEnemyQueue(enemyQueue);
                        tournamentUi.show();
                        break;
                    case 1:
                        tournamentUi = new TournamentUi(this.getContext(), this.getLoc().getTournaments().get(1));
                        enemyQueue = new LinkedList<>(this.getLoc().getTournaments()
                                .get(1).getEnemyList());
                        this.getContext().getHero().getHeroInteraction().setEnemyQueue(enemyQueue);
                        tournamentUi.show();
                        break;
                    case 2:
                        tournamentUi = new TournamentUi(this.getContext(), this.getLoc().getTournaments().get(2));
                        enemyQueue = new LinkedList<>(this.getLoc().getTournaments()
                                .get(2).getEnemyList());
                        this.getContext().getHero().getHeroInteraction().setEnemyQueue(enemyQueue);
                        tournamentUi.show();
                        break;
                    default:
                        tournamentUi = new TournamentUi(this.getContext(), this.getLoc().getTournaments().get(0));
                        enemyQueue = new LinkedList<>(this.getLoc().getTournaments()
                                .get(0).getEnemyList());
                        this.getContext().getHero().getHeroInteraction().setEnemyQueue(enemyQueue);
                        tournamentUi.show();
                        break;
                }
        }
    }
}
