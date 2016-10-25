package cz.vsb.ekf.lan0116.world;

import cz.vsb.ekf.lan0116.world.location.*;
import cz.vsb.ekf.lan0116.world.location.building.Arena;
import cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop.Grocery;
import cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop.SwiftDrink;
import cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop.Archery;
import cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop.Blacksmith;
import cz.vsb.ekf.lan0116.world.location.building.shop.Tavern;
import cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop.WandShop;
import cz.vsb.ekf.lan0116.world.location.street.CrossRoad;
import cz.vsb.ekf.lan0116.world.location.street.Road;
import cz.vsb.ekf.lan0116.world.location.street.Square;
import cz.vsb.ekf.lan0116.world.location.street.Street;

public class World {

    private Location startLocation;

    //SHOPS
    private static Archery archery;
    private static Blacksmith blacksmith;
    private static WandShop wandShop;

    private static Grocery grocery;
    private static SwiftDrink swiftDrink;

    //BUILDINGS
    private static Tavern tavern;
    private static Street tavernBackyard;

    private static Arena arena;

    //STREETS
    private static Street battleQuarter;

    private static Street centralCrossroad;
    private static Street indecisiveCrossroad;

    private static Street centralRoad;
    private static Street cordialAlley;
    private static Street roadOfConflict;
    private static Street roadOfMalice;

    public World(Location startLocation) {
        this.startLocation = startLocation;

        archery = new Archery();
        blacksmith = new Blacksmith();
        wandShop = new WandShop();

        grocery = new Grocery();
        swiftDrink = new SwiftDrink();

        tavern = new Tavern();
        tavernBackyard = new Road("world.street.tavern_backyard");

        arena = new Arena("world.arena.arena");

        battleQuarter = new Square("world.street.battle_quarter");

        centralCrossroad = new CrossRoad("world.street.central_crossroad");
        indecisiveCrossroad = new CrossRoad("world.street.indecisive_crossroad");


        centralRoad = new Road("world.street.central_road");
        cordialAlley = new Road("world.street.cordial_alley");
        roadOfConflict = new Road("world.street.road_of_conflict");
        roadOfMalice = new Road("world.street.road_of_malice");
    }

    /**
     * Static method giving example how world could look like and connecting locations via Gateways
     *
     * @return
     */
    public static World example() {
        Location startLocation = new Square("world.street.main_square");
        World world = new World(startLocation);
        Location.link(startLocation,grocery);
        Location.link(startLocation,swiftDrink);
        Location.link(startLocation, tavern);

        //FROM TAVERN TO BATTLE QUARTER
        Location.link(tavern, tavernBackyard);
        Location.link(tavernBackyard, cordialAlley);
        Location.link(cordialAlley, indecisiveCrossroad);
        Location.link(indecisiveCrossroad, roadOfMalice);
        Location.link(roadOfMalice, battleQuarter);

        //FROM MAIN SQUARE TO BATTLE QUARTER
        Location.link(startLocation, centralRoad);
        Location.link(centralRoad, centralCrossroad);
        Location.link(centralCrossroad, roadOfConflict);
        Location.link(roadOfConflict, battleQuarter);
        Location.link(battleQuarter, archery);
        Location.link(battleQuarter, arena);
        Location.link(battleQuarter, blacksmith);
        Location.link(battleQuarter, wandShop);
        return world;
    }

    public Location getStartLocation() {
        return startLocation;
    }
}
