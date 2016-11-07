package cz.vsb.ekf.lan0116.world.location.wilderness;

import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.type.WildernessType;

import java.util.List;

public class Wilderness extends Location {

    private List<? extends Location> areas;

    public Wilderness(String nameOfLocation) {
        super(nameOfLocation, WildernessType.WILDERNESS);
    }

}
