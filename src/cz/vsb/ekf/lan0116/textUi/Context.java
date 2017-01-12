package cz.vsb.ekf.lan0116.textUi;

import cz.vsb.ekf.lan0116.eventSystem.Session;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventPublisher;
import cz.vsb.ekf.lan0116.util.Localization;
import cz.vsb.ekf.lan0116.util.ObjectFactory;
import cz.vsb.ekf.lan0116.world.World;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.Scanner;

public class Context {
    private final EventPublisher eventPublisher;
    private final Hero hero;
    private final World world;
    private final ObjectFactory factory;
    private final Scanner scanner;
    private final Localization localization;
    private final Session session;


    public Context(EventPublisher eventPublisher, Hero hero, World world, ObjectFactory factory, Scanner scanner,
                   Localization localization, Session session) {
        this.eventPublisher = eventPublisher;
        this.hero = hero;
        this.world = world;
        this.factory = factory;
        this.scanner = scanner;
        this.localization = localization;
        this.session = session;
    }

    public EventPublisher getEventPublisher() {
        return eventPublisher;
    }

    public Hero getHero() {
        return hero;
    }

    public World getWorld() {
        return world;
    }

    public ObjectFactory getFactory() {
        return factory;
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
