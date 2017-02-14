package cz.vsb.ekf.lan0116.world;

import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.util.cloner.Clone;
import cz.vsb.ekf.lan0116.util.cloner.creature.HumanoidCloning;
import cz.vsb.ekf.lan0116.util.cloner.iClone;
import cz.vsb.ekf.lan0116.util.cloner.item.ConsumableCloning;
import cz.vsb.ekf.lan0116.util.cloner.item.WeaponCloning;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Merchant;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.Weapon;
import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.building.Arena;
import cz.vsb.ekf.lan0116.world.location.building.shop.Tavern;
import cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop.DrinkShop;
import cz.vsb.ekf.lan0116.world.location.building.shop.consumableShop.FoodShop;
import cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop.Archery;
import cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop.Blacksmith;
import cz.vsb.ekf.lan0116.world.location.building.shop.weaponShop.WandShop;
import cz.vsb.ekf.lan0116.world.location.street.CrossRoad;
import cz.vsb.ekf.lan0116.world.location.street.Road;
import cz.vsb.ekf.lan0116.world.location.street.Square;
import cz.vsb.ekf.lan0116.world.location.street.Street;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Location startLocation;

    private ConsumableCloning consumableCloning;
    private HumanoidCloning humanoidCloning;
    private WeaponCloning weaponCloning;

    //SHOPS
    private static Archery archery;
    private static Blacksmith blacksmith;
    private static WandShop wandShop;

    private static DrinkShop grocery;
    private static FoodShop swiftDrink;

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

    public World(Location startLocation, ResourceCache cache) {
        this.consumableCloning = new ConsumableCloning(cache);
        this.humanoidCloning = new HumanoidCloning(cache);
        this.weaponCloning = new WeaponCloning(cache);
        this.startLocation = startLocation;
        this.init(cache);
    }

    /**
     * Static method giving layout how world could look like and connecting locations via Gateways
     *
     * @return
     */
    public static World layout(ResourceCache cache) {
        Location startLocation = new Square("world.square.main_square");
        World world = new World(startLocation, cache);
        Location.link(startLocation, grocery);
        Location.link(startLocation, swiftDrink);
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
        Location.link(firstAvenue, townGate);
        return world;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void init(ResourceCache cache) {

        //WEAPON SHOP START
        //archery init
        List<String> archeryString = ResourceUtil.getResource(ResourceType.WEAPON_SHOP, "archery");
        List<Merchandise> archeryMerch = new ArrayList<>();
        for (String id : archeryString) {
            archeryMerch.add(weaponCloning.clone(id));
        }
        archery = new Archery("world.building.shop.weapon_shop.archery",
                (Merchant) humanoidCloning.clone("merchant.weapons.hunter"), archeryMerch);

        //blacksmith init
        List<String> blacksmithString = ResourceUtil.getResource(ResourceType.WEAPON_SHOP, "blacksmith");
        List<Merchandise> blaskmithMerch = new ArrayList<>();
        for (String id : blacksmithString) {
            blaskmithMerch.add(weaponCloning.clone(id));
        }
        blacksmith = new Blacksmith("world.building.shop.weapon_shop.blacksmith",
                (Merchant) humanoidCloning.clone("merchant.weapons.blacksmith"), blaskmithMerch);

        //wand shop init
        List<String> wandShopString = ResourceUtil.getResource(ResourceType.WEAPON_SHOP, "wand_shop");
        List<Merchandise> wandShopMerch = new ArrayList<>();
        for (String id : wandShopString) {
            wandShopMerch.add(weaponCloning.clone("id"));
        }
        wandShop = new WandShop("world.building.shop.weapon_shop.wand_shop",
                (Merchant) humanoidCloning.clone("merchant.weapons.wizard"), wandShopMerch);
        //WEAPON SHOP END

        //CONSUMABLE SHOP START
        grocery = new FoodShop("world.building.shop.consumable_shop.grocery",
                (Merchant) humanoidCloning.clone("merchant.consumables.food_shop.gordon"), );
        swiftDrink = new DrinkShop();

        tavern = new Tavern();
        tavernBackyard = new Road("world.road.tavern_backyard");
        //CONSUMABLE SHOP END

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
}
