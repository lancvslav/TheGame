package cz.vsb.ekf.lan0116.textUi.abstracts;

import cz.vsb.ekf.lan0116.eventSystem.events.hero.TravelEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.BattleLogServerEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.DamageInfliction;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat.FightResponse;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.location.Gateway;
import cz.vsb.ekf.lan0116.world.location.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLocationUi<L extends Location> extends AbstractUi {

    protected AbstractLocationUi(Context context) {
        super(context);
    }

    public L getLoc() {
        return (L) this.getContext().getHero().getHeroInteraction().getPosition();
    }

    /**
     * Called, when user decides to travel to another location
     */
    protected void travel() {
        Location loc = getContext().getHero().getHeroInteraction().getPosition();
        System.out.print("\n" + this.get("textUi.AbstractLocationUi.where"));
        int choice = this.choice(loc.getGateways().stream()
                .map(Gateway::getTarget)//RETURNS Location LINKED TO CURRENT ONE
                .map(Location::getName)//RETURNS String name OF COLLECTED Location
                .map(this.getContext().getLocalization()::get)
                .toArray(String[]::new));
        if (choice >= 0 && choice < loc.getGateways().size()) {//CHECKING IF USER SELECTED CHOICE FROM OFFERED ONES
            this.getContext().getSession().fireEvent(new TravelEvent(loc.getGateways().get(choice)));
        } else {
            System.out.println("\n" + this.get("textUi.AbstractLocationUi.you_hit"));
            List<FightResponse> selfDamage = new ArrayList<>();
            selfDamage.add(new DamageInfliction(this.getContext().getHero(),
                    this.getContext().getHero(), 1.0F));
            this.getContext().getSession().getResponseChannel()
                    .respond(new BattleLogServerEvent(selfDamage));
            this.travel();
        }
    }

}
