package cz.vsb.ekf.lan0116.world.location;

import cz.vsb.ekf.lan0116.world.location.type.LocationSuperType;
import cz.vsb.ekf.lan0116.world.location.type.LocationType;

import java.util.ArrayList;
import java.util.List;

//ALL PLACES EXTENDS THIS CLASS, EACH CLASS HAS TO SPECIFY WHAT type OF LOCATION CURRENT INSTANCE IS
//SUBCLASSES MAY HAVE OTHER SUBCLASSES, CLOSELY SPECIFYING CURRENT type OF PLACE (SHOP -> BLACKSMITH etc.)
public class Location {

    private final String name;
    private final LocationType type;
    private final List<Gateway> gateways;

    /**
     * @param nameOfLocation
     * @param type Type of location selected from enum 'LocationTypeDeprecated'
     * @param
     */
    public Location(String nameOfLocation, LocationType type) {
        this.name = nameOfLocation;
        this.type = type;
        gateways = new ArrayList<>();
    }

    public LocationType getType() {
        return type;
    }

    public LocationSuperType getSuperType(){return this.getType().getSuperType();}

    public String getName() {
        return name;
    }

    public List<Gateway> getGateways() {
        return gateways;
    }

    /**
     * Binds two locations together via Gateway
     *
     * @param loc1
     * @param loc2
     */
    public static void link(Location loc1, Location loc2) {
        loc1.gateways.add(new Gateway(loc2));
        loc2.gateways.add(new Gateway(loc1));
    }

    @Override
    public String toString() {
        return name;
    }

}
