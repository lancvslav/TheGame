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
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.Map;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        World world = World.example();
        Localization localization = new Localization
                (ResourceUtil.getResource(ResourceType.LOCALIZATION, "localization"));

        Map<String, Attack> attackMap = ResourceToMapUtil.createAttackMap(ResourceUtil
                .getResource(ResourceType.ATTACK_ALL, "attacks"));
        ObjectFactory factory = new ObjectFactory(attackMap,
                ResourceToMapUtil.createConsumableMap(ResourceUtil
                        .getResource(ResourceType.CONSUMABLE_ALL, "consumables")),
                ResourceToMapUtil.createCreatureMap(ResourceUtil
                        .getResource(ResourceType.CREATURES_ALL, "creatures")),
                null,
                ResourceToMapUtil.createWeaponMap(ResourceUtil
                                .getResource(ResourceType.WEAPON_ALL, "weapons"),
                        attackMap));

        Scanner scanner = new Scanner(System.in, "UTF-8");
        Hero hero = HeroCreationUi.creationOfHero(scanner, localization);
        ResponseChannel responseChannel = new ResponseChannel();
        EventPublisher eventPublisher = new EventPublisher(hero, world, responseChannel);
        Session session = new Session(eventPublisher, responseChannel);
        Context context = new Context(eventPublisher, hero, world, factory, scanner, localization, session);
        TextEvents textEvents = new TextEvents(context);
        textEvents.playGame();
    }
}
