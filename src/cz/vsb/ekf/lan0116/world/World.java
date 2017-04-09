package cz.vsb.ekf.lan0116.world;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.util.cloner.creature.AnimalCloning;
import cz.vsb.ekf.lan0116.util.cloner.creature.HumanoidCloning;
import cz.vsb.ekf.lan0116.util.cloner.item.ConsumableCloning;
import cz.vsb.ekf.lan0116.util.cloner.item.WeaponCloning;
import cz.vsb.ekf.lan0116.world.creature.Animal;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
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

    private AnimalCloning animalCloning;
    private ConsumableCloning consumableCloning;
    private HumanoidCloning humanoidCloning;
    private WeaponCloning weaponCloning;

    //SHOPS
    private static Archery archery;
    private static Blacksmith blacksmith;
    private static WandShop wandShop;

    private static FoodShop grocery;
    private static DrinkShop swiftDrink;

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
        this.animalCloning = new AnimalCloning(cache);
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
        Location.link(startLocation, battleQuarter);

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

        //SHOP START
        //WEAPON SHOP START
        //archery init
        List<String> archeryString = ResourceUtil.getResource(ResourceType.WEAPON_SHOP,
                "world.building.shop.weapon_shop.archery");
        List<Merchandise> archeryMerch = new ArrayList<>();
        for (String id : archeryString) {
            archeryMerch.add(weaponCloning.clone(id));
        }
        archery = new Archery("world.building.shop.weapon_shop.archery",
                humanoidCloning.clone("npc.merchant.weapons.hunter.Scariel"), archeryMerch);

        //blacksmith init
        List<String> blacksmithString = ResourceUtil.getResource(ResourceType.WEAPON_SHOP,
                "world.building.shop.weapon_shop.blacksmith");
        List<Merchandise> blaskmithMerch = new ArrayList<>();
        for (String id : blacksmithString) {
            blaskmithMerch.add(weaponCloning.clone(id));
        }
        blacksmith = new Blacksmith("world.building.shop.weapon_shop.blacksmith",
                humanoidCloning.clone("npc.merchant.weapons.blacksmith.Greg"), blaskmithMerch);

        //wand shop init
        List<String> wandShopString = ResourceUtil.getResource(ResourceType.WEAPON_SHOP,
                "world.building.shop.weapon_shop.wand_shop");
        List<Merchandise> wandShopMerch = new ArrayList<>();
        for (String id : wandShopString) {
            wandShopMerch.add(weaponCloning.clone(id));
        }
        wandShop = new WandShop("world.building.shop.weapon_shop.wand_shop",
                humanoidCloning.clone("npc.merchant.weapons.wizard.Priscilus"), wandShopMerch);
        //WEAPON SHOP END

        //CONSUMABLE SHOP START
        //grocery init
        List<String> groceryString = ResourceUtil.getResource(ResourceType.CONSUMABLE_SHOP,
                "world.building.shop.consumable_shop.grocery");
        List<Merchandise> groceryMerch = new ArrayList<>();
        for (String id : groceryString) {
            groceryMerch.add(consumableCloning.clone(id));
        }
        grocery = new FoodShop("world.building.shop.consumable_shop.grocery",
                humanoidCloning.clone("npc.merchant.consumables.food_shop.gordon"), groceryMerch);

        //swift drink init
        List<String> swiftString = ResourceUtil.getResource(ResourceType.CONSUMABLE_SHOP,
                "world.building.shop.consumable_shop.swift_drink");
        List<Merchandise> swiftMerch = new ArrayList<>();
        for (String id : swiftString) {
            swiftMerch.add(consumableCloning.clone(id));
        }
        swiftDrink = new DrinkShop("world.building.shop.consumable_shop.swift_drink",
                humanoidCloning.clone("npc.merchant.consumables.drink_shop.joe"), swiftMerch);

        //tavern init
        List<String> drinkString = ResourceUtil.getResource(ResourceType.CONSUMABLE_SHOP,
                "world.building.shop.tavern.drink");
        List<Merchandise> drinkMerch = new ArrayList<>();
        for (String id : drinkString) {
            drinkMerch.add(consumableCloning.clone(id));
        }
        List<String> foodString = ResourceUtil.getResource(ResourceType.CONSUMABLE_SHOP,
                "world.building.shop.tavern.food");
        List<Merchandise> foodMerch = new ArrayList<>();
        for (String id : foodString) {
            foodMerch.add(consumableCloning.clone(id));
        }
        tavern = new Tavern(humanoidCloning.clone("npc.innkeeper.tavern.gwen"), drinkMerch, foodMerch);
        //CONSUMABLE SHOP END
        //SHOP END

        //ARENA
        List<String> humanoidString = ResourceUtil.getResource(ResourceType.ARENA_ENEMY, "arena0");
        List<String> anim1String = ResourceUtil.getResource(ResourceType.ARENA_ENEMY, "arena1");
        List<String> anim2String = ResourceUtil.getResource(ResourceType.ARENA_ENEMY, "arena2");

        List<Humanoid> humanoids = new ArrayList<>();
        for (String id : humanoidString) {
            humanoids.add(humanoidCloning.clone(id));
        }
        Tournament tournament0 = new Tournament("humanoids", humanoids);

        List<Animal> animals1 = new ArrayList<>();
        for (String id : anim1String) {
            animals1.add(animalCloning.clone(id));
        }
        Tournament tournament1 = new Tournament("animals", animals1);

        List<Animal> animals2 = new ArrayList<>();
        for (String id : anim2String) {
            animals2.add(animalCloning.clone(id));
        }
        Tournament tournament2 = new Tournament("fishes", animals2);

        List<Tournament> tournaments = new ArrayList<>();
        tournaments.add(tournament0);
        tournaments.add(tournament1);
        tournaments.add(tournament2);

        arena = new Arena("world.arena.arena", tournaments);


        //STREET START
        tavernBackyard = new Road("world.road.tavern_backyard");

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
