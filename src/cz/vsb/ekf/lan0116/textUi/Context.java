package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventSystem.Session;
import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.util.ResourceCache;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.Scanner;

/**
 * simulate function similar to application server
 */
public class Context {
    private final Hero hero;
    private final World world;
    private final ResourceCache cache;
    private final Scanner scanner;
    private final Localization localization;
    private final Session session;


    public Context(Hero hero, World world, ResourceCache cache, Scanner scanner,
                   Localization localization, Session session) {
        this.hero = hero;
        this.world = world;
        this.cache = cache;
        this.scanner = scanner;
        this.localization = localization;
        this.session = session;
    }

    public Hero getHero() {
        return hero;
    }

    public World getWorld() {
        return world;
    }

    public ResourceCache getCache() {
        return cache;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Localization getLocalization() {
        return localization;
    }

    public Session getSession() {
        return session;
    }
}
