package cz.vsb.ekf.lan0116.world;

import cz.vsb.ekf.lan0116.world.building.Arena;
import cz.vsb.ekf.lan0116.world.building.shop.weaponShop.Archery;
import cz.vsb.ekf.lan0116.world.building.shop.weaponShop.Blacksmith;
import cz.vsb.ekf.lan0116.world.building.shop.Tavern;
import cz.vsb.ekf.lan0116.world.building.shop.weaponShop.WandShop;

public class World {

    private Location startLocation;

    private static Archery archery;
    private static Blacksmith blacksmith;
    private static WandShop wandShop;

    private static Tavern tavern;

    private static Arena arena;
    private static Street battleQuarter;
    private static Street centralCrossRoad;
    private static Street centralRoad;
    private static Street roadOfBattle;

    public World(Location startLocation) {
        this.startLocation = startLocation;

        this.archery = new Archery();
        this.blacksmith = new Blacksmith();
        this.wandShop = new WandShop();

        this.tavern = new Tavern();

        this.arena = new Arena("world.arena.arena");

        this.battleQuarter = new Street("world.street.battle_quarter");
        this.centralCrossRoad = new Street("world.street.central_crossroad");
        this.centralRoad = new Street("world.street.central_road");
        this.roadOfBattle = new Street("world.street.road_of_battle");
    }

    /**
     * Static method giving example how world could look like and connecting locations via Gateways
     *
     * @return
     */
    public static World example() {
        Location startLocation = new Street("world.street.main_square");
        World world = new World(startLocation);
        Location.link(startLocation, tavern);
        Location.link(centralRoad, startLocation);
        Location.link(centralCrossRoad, centralRoad);
        Location.link(centralCrossRoad, roadOfBattle);
        Location.link(battleQuarter,roadOfBattle);
        Location.link(arena,battleQuarter);
        Location.link(archery,battleQuarter);
        Location.link(battleQuarter, blacksmith);
        Location.link(battleQuarter, wandShop);
        return world;
    }

    public Location getStartLocation() {
        return startLocation;
    }
}
