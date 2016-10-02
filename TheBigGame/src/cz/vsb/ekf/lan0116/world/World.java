package cz.vsb.ekf.lan0116.world;

import cz.vsb.ekf.lan0116.combat.Arena;
import cz.vsb.ekf.lan0116.world.buildings.Archery;
import cz.vsb.ekf.lan0116.world.buildings.Blacksmith;
import cz.vsb.ekf.lan0116.world.buildings.WandShop;

public class World {

    private Location startLocation;

    public World(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    /**
     * Static method giving example how world could look like and connecting locations via Gateways
     *
     * @return
     */
    public static World example() {
        Location startLocation = new Street("world.street.main_square");
        World world = new World(startLocation);
        Location.link(startLocation, new Archery());
        Location.link(startLocation, new Blacksmith());
        Location.link(startLocation, new WandShop());
        Location.link(startLocation, new Arena("world.arena.arena"));
        return world;
    }
}
