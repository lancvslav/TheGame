package cz.vsb.ekf.lan0116.world;

import java.util.ArrayList;
import java.util.List;

//ALL PLACES EXTENDS THIS CLASS, EACH CLASS HAS TO SPECIFY WHAT TYPE OF LOCATION CURRENT INSTANCE IS
//SUBCLASSES MAY HAVE OTHER SUBCLASSES, CLOSELY SPECIFYING CURRENT TYPE OF PLACE (SHOP -> BLACKSMITH etc.)
public class Location {

    private final String name;
    private final LocationType type;
    private final List<Gateway> gateways;

    /**
     * @param nameOfLocation
     * @param locationType   Type of location selected from enum 'LocationType'
     * @param
     */
    public Location(String nameOfLocation, LocationType locationType) {
        this.name = nameOfLocation;
        this.type = locationType;
        gateways = new ArrayList<>();
    }

    public LocationType getType() {
        return type;
    }

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
