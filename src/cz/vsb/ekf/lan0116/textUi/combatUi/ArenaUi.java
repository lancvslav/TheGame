package cz.vsb.ekf.lan0116.textUi.combatUi;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.GetReadyEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.SignInEvent;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.world.location.building.Arena;

public class ArenaUi extends AbstractLocationUi {

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
                System.out.println(this.get("textUi.StreetUi.paths") + ":");
                for (int i = 0; i < this.getLoc().getGateways().size(); i++) {
                    System.out.println(this.get(this.getLoc().getGateways().get(i).getTarget().getName()));
                }
                this.getContext().getSession().fireEvent(new GetReadyEvent());
                this.travel();
                break;
            case 1:
                System.out.println("\n" + this.get("textUi.ArenaUi.entered_tournament"));
                switch (this.choice(this.get("textUi.ArenaUi.tournament0"),
                        this.get("textUi.ArenaUi.tournament1"),
                        this.get("textUi.ArenaUi.tournament2"))) {
                    case 0:
                        this.getContext().getSession().fireEvent(new SignInEvent(this.getLoc().getTournaments().get(0)));
                        new TournamentUi(this.getContext()).show();
                        break;
                    case 1:
                        this.getContext().getSession().fireEvent(new SignInEvent(this.getLoc().getTournaments().get(1)));
                        new TournamentUi(this.getContext()).show();
                        break;
                    case 2:
                        this.getContext().getSession().fireEvent(new SignInEvent(this.getLoc().getTournaments().get(2)));
                        new TournamentUi(this.getContext()).show();
                        break;
                    default:
                        this.getContext().getSession().fireEvent(new SignInEvent(this.getLoc().getTournaments().get(0)));
                        new TournamentUi(this.getContext()).show();
                        break;
                }
        }
    }
}
