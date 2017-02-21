package cz.vsb.ekf.lan0116;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.Session;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventPublisher;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextEvents;
import cz.vsb.ekf.lan0116.textUi.heroUi.HeroCreationUi;
import cz.vsb.ekf.lan0116.util.*;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.item.Consumable;
import cz.vsb.ekf.lan0116.world.item.Weapon;

import java.util.Map;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Language/Jazyk");
        String pref;
        do {
            System.out.println("en/cz");
            pref = scanner.nextLine();
        } while (!(pref.equals("en") || pref.equals("cz")));
        Localization l;
        switch (pref) {
            case "en":
                l = new Localization
                        (ResourceUtil.getResource(ResourceType.LOCALIZATION, "en"));
                break;
            case "cz":
                l = new Localization
                        (ResourceUtil.getResource(ResourceType.LOCALIZATION, "cz"));
                break;
            default:
                l = new Localization
                        (ResourceUtil.getResource(ResourceType.LOCALIZATION, "en"));
                break;
        }
        Localization localization = l;

        Map<String, Attack> attackMap = ResourceToMapUtil.createAttackMap(ResourceUtil
                .getResource(ResourceType.ATTACK_ALL, "attacks"));
        Map<String, Consumable> consumableMap = ResourceToMapUtil.createConsumableMap(ResourceUtil
                .getResource(ResourceType.CONSUMABLE_ALL, "consumables"));
        Map<String, Weapon> weaponMap = ResourceToMapUtil.createWeaponMap(ResourceUtil
                        .getResource(ResourceType.WEAPON_ALL, "weapons"),
                attackMap);
        Map<String, Creature> creatureMap = ResourceToMapUtil.createCreatureMap(ResourceUtil
                .getResource(ResourceType.CREATURES_ALL, "creatures"), attackMap, weaponMap);

        ResourceCache cache = new ResourceCache(attackMap, consumableMap, creatureMap, null, weaponMap);
        World world = World.layout(cache);

        Hero hero = HeroCreationUi.creationOfHero(scanner, localization);
        ResponseChannel responseChannel = new ResponseChannel();
        EventPublisher eventPublisher = new EventPublisher(hero, world, responseChannel);
        Session session = new Session(eventPublisher, responseChannel);
        Context context = new Context(hero, world, cache, scanner, localization, session);
        TextEvents textEvents = new TextEvents(context);
        textEvents.playGame();
    }
}

