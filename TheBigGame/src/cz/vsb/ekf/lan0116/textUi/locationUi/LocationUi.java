package cz.vsb.ekf.lan0116.textUi.locationUi;

import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.abstracts.AbstractLocationUi;
import cz.vsb.ekf.lan0116.textUi.combatUi.ArenaUi;
import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;

public class LocationUi extends AbstractLocationUi<Location> {

    private ArenaUi arenaUi;
    private ShopUi shopUi;
    private StreetUi streetUi;
    private LocationType locType;


    public LocationUi(Context context) {
        super(context);
    }

    /**
     * Prints locations where user can go from current one, reading from ArrayList in class Gateway,
     * Prints decisions, what user can in
     * current location do
     */
    @Override
    public void show() {
        locType = this.getLoc().getType();
        System.out.println("_______________________________________________");
        switch (locType) {
            case SHOP:
                shopUi = new ShopUi(this.getContext());
                shopUi.show();
                return;
            case WILDERNESS:
                return;
            case STREET:
                streetUi = new StreetUi(this.getContext());
                streetUi.show();
                return;
            case ARENA:
                arenaUi = new ArenaUi(this.getContext());
                arenaUi.show();
                return;
            default:
                throw new AssertionError(locType.name());
        }
    }
}
