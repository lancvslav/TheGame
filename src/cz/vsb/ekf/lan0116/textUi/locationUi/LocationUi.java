package cz.vsb.ekf.lan0116.textUi.locationUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.textUi.combatUi.ArenaUi;
import cz.vsb.ekf.lan0116.textUi.combatUi.TournamentUi;
import cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.shopUi.ShopUi;
import cz.vsb.ekf.lan0116.textUi.locationUi.buildingUi.tavern.TavernUi;
import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.type.ArenaType;
import cz.vsb.ekf.lan0116.world.location.type.LocationSuperType;

public class LocationUi extends AbstractLocationUi<Location> {

    private LocationSuperType locType;


    public LocationUi(Context context) {
        super(context);
    }

    /**
     * this is some kind of fork which decides what kind of screen should be printed, based on type of location
     * the player is currently in
     */
    @Override
    public void show() {
        locType = this.getLoc().getSuperType();
        System.out.print("________________________________________________________________________________");
        switch (locType) {
            case ARENA:
                ArenaType arenaType = (ArenaType) this.getLoc().getType();
                switch (arenaType) {
                    case ARENA:
                        new ArenaUi(this.getContext()).show();
                        break;
                    case TOURNAMENT:
                        new TournamentUi(this.getContext()).show();
                        break;
                }
                return;
            case SHOP:
                new ShopUi(this.getContext()).show();
                return;
            case STREET:
                new StreetUi(this.getContext()).show();
                return;
            case TAVERN:
                new TavernUi(this.getContext()).show();
            case WILDERNESS:
                return;
            default:
                throw new AssertionError(locType.name());
        }
    }

    @Override
    public void decisions() {

    }
}
