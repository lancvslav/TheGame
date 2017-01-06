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
    private static Square battleQuarter;

    private static CrossRoad centralCrossroad;
    private static CrossRoad indecisiveCrossroad;
    private static CrossRoad townGate;

    private static Road centralRoad;
    private static Road cordialAlley;
    private static Road firstAvenue;
    private static Road roadOfConflict;
    private static Road roadOfMalice;

    public World(Location startLocation) {
        this.startLocation = startLocation;

        archery = new Archery();
        blacksmith = new Blacksmith();
        wandShop = new WandShop();

        grocery = new Grocery();
        swiftDrink = new SwiftDrink();

        tavern = new Tavern();
        tavernBackyard = new Road("world.road.tavern_backyard");

        arena = new Arena("world.arena.arena");

        battleQuarter = new Square("world.square.battle_quarter");

        centralCrossroad = new CrossRoad("world.crossroad.central_crossroad");
        indecisiveCrossroad = new CrossRoad("world.crossroad.indecisive_crossroad");
        townGate = new CrossRoad("world.crossroad.town_gate");

        centralRoad = new Road("world.road.central_road");
        cordialAlley = new Road("world.road.cordial_alley");
        firstAvenue = new Road("world.road.fist_avenue");
        roadOfConflict = new Road("world.road.road_of_conflict");
        roadOfMalice = new Road("world.road.road_of_malice");
    }

    /**
     * Static method giving example how world could look like and connecting locations via Gateways
     *
     * @return
     */
    public static World example() {
        Location startLocation = new Square("world.square.main_square");
        World world = new World(startLocation);
        Location.link(startLocation,grocery);
        Location.link(startLocation,swiftDrink);
        Location.link(startLocation, tavern);
        Location.link(startLocation, arena);

        //TAVERN -> BATTLE QUARTER
        Location.link(tavern, tavernBackyard);
        Location.link(tavernBackyard, cordialAlley);
        Location.link(cordialAlley, indecisiveCrossroad);
        Location.link(indecisiveCrossroad, roadOfMalice);
        Location.link(roadOfMalice, battleQuarter);

        //MAIN SQUARE -> BATTLE QUARTER
        Location.link(startLocation, centralRoad);
        Location.link(centralRoad, centralCrossroad);
        Location.link(centralCrossroad, roadOfConflict);
        Location.link(roadOfConflict, battleQuarter);
        Location.link(battleQuarter, archery);
        Location.link(battleQuarter, arena);
        Location.link(battleQuarter, blacksmith);
        Location.link(battleQuarter, wandShop);

        //CENTRAL -> TOWN GATE
        Location.link(centralCrossroad, firstAvenue);
        Location.link(firstAvenue,townGate);
        return world;
    }

    public Location getStartLocation() {
        return startLocation;
    }
}
