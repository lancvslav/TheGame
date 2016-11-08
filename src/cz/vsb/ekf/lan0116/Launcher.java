package cz.vsb.ekf.lan0116;

import cz.vsb.ekf.lan0116.eventSystem.Session;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventPublisher;
import cz.vsb.ekf.lan0116.eventSystem.events.ResponseChannel;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.TextEvents;
import cz.vsb.ekf.lan0116.textUi.heroUi.HeroCreationUi;
import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        World world = World.example();
        Localization localization = new Localization
                (ResourceUtil.getResource(ResourceType.LOCALIZATION, "localization"));
        Scanner scanner = new Scanner(System.in, "UTF-8");
        Hero hero = HeroCreationUi.creationOfHero(scanner, localization);
        ResponseChannel responseChannel = new ResponseChannel();
        EventPublisher eventPublisher = new EventPublisher(hero, world, responseChannel);
        Session session = new Session(eventPublisher, responseChannel);
        Context context = new Context(eventPublisher, hero, world, scanner, localization, session);
        TextEvents textEvents = new TextEvents(context);
        textEvents.playGame();
    }
}
