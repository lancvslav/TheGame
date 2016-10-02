package cz.vsb.ekf.lan0116;

import cz.vsb.ekf.lan0116.events.EventHandler;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.textUi.HeroCreationUi;
import cz.vsb.ekf.lan0116.textUi.TextEvents;
import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        //Creation of hero BRUTALLY HARDCODED!!!
        World world = World.example();
        Localization localization = new Localization(ResourceUtil.getResource(ResourceType.LOCALIZATION, "localization"));
        Scanner scanner = new Scanner(System.in, "UTF-8");
        Hero hero = HeroCreationUi.creationOfHero(scanner, localization);
        EventHandler eventHandler = new EventHandler(hero, world);
        Context context = new Context(eventHandler, hero, world, scanner, localization);
        TextEvents textEvents = new TextEvents(context);
        textEvents.playGame();
    }

}
