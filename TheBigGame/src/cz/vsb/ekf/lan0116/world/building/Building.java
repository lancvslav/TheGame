package cz.vsb.ekf.lan0116.world.building;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;

public class Building extends Location {

    /**
     * @param nameOfLocation
     * @param locationType   Type of location selected from enum 'LocationType'
     */
    public Building(String nameOfLocation, LocationType locationType) {
        super(nameOfLocation, locationType);
    }
}
