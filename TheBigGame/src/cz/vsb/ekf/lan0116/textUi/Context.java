package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventsHandling.eventHandler.EventHandlerMain;
import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.Scanner;

public class Context {

    private final EventHandlerMain eventHandlerMain;
    private final Hero hero;
    private final World world;
    private final Scanner scanner;
    private final Localization localization;


    public Context(EventHandlerMain eventHandlerMain, Hero hero, World world, Scanner scanner, Localization localization) {
        this.eventHandlerMain = eventHandlerMain;
        this.hero = hero;
        this.world = world;
        this.scanner = scanner;
        this.localization = localization;

    }

    public EventHandlerMain getEventHandlerMain() {
        return eventHandlerMain;
    }

    public Hero getHero() {
        return hero;
    }

    public World getWorld() {
        return world;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Localization getLocalization() {
        return localization;
    }
}
