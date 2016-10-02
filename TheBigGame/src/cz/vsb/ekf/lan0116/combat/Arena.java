package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class Arena extends Location {

    private Hero hero;
    private Tournament tournament;

    public Arena(String nameOfLocation) {
        super(nameOfLocation, LocationType.ARENA);
    }

}
