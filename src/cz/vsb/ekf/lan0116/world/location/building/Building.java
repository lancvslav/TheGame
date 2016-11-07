package cz.vsb.ekf.lan0116.world.location.building;

import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.type.LocationType;

public class Building extends Location {

    /**
     * @param nameOfLocation
     */
    public Building(String nameOfLocation, LocationType buildingType) {
        super(nameOfLocation, buildingType);
    }
}
