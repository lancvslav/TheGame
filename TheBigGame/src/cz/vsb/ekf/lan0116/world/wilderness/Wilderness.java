package cz.vsb.ekf.lan0116.world.wilderness;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;

import java.util.List;

public class Wilderness extends Location {

    private List<? extends Location> areas;

    public Wilderness(String nameOfLocation) {
        super(nameOfLocation, LocationType.WILDERNESS);
    }

}
