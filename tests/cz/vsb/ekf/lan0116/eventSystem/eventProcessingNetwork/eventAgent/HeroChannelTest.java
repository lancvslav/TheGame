package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.eventSystem.Session;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventPublisher;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.GetReadyEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.SignInEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.TravelEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.EquipEvent;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.HeroInteraction;
import cz.vsb.ekf.lan0116.world.creature.hero.Ranger;
import cz.vsb.ekf.lan0116.world.item.Weapon;
import cz.vsb.ekf.lan0116.world.item.type.WeaponType;
import cz.vsb.ekf.lan0116.world.location.Gateway;
import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.street.Street;
import cz.vsb.ekf.lan0116.world.location.type.StreetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HeroChannelTest {

    private Hero hero;
    HeroChannel heroChannel;
    private EventPublisher publisher;
    private Session session;

    EquipEvent equipEvent;
    GetReadyEvent getReadyEvent;
    SignInEvent signInEvent;
    TravelEvent travelEvent;

    @BeforeEach
    void setUp() {
        //preparation
        hero = new Ranger("Tester");
        publisher = new EventPublisher(hero, null, null);
        session = new Session(publisher, null);
        heroChannel = new HeroChannel(hero, null, null);

        //Equip start
        Weapon weapon = new Weapon("Mock bow", WeaponType.RANGED, 1, 1, null);
        hero.getInventory().addItem(weapon);
        equipEvent = new EquipEvent(weapon);
        //equip end

        //Get ready start
        getReadyEvent = new GetReadyEvent();
        //get ready end

        //Sign in start
        Creature enemy = new Creature("Mockster", CreatureClass.WARRIOR, 10, 10, 10, 10);
        List<Creature> enemyList = new ArrayList<>();
        enemyList.add(enemy);
        Tournament tournament = new Tournament("Testament", enemyList);
        signInEvent = new SignInEvent(tournament);
        //sign in end

        //Travel start
        Location start = new Street("start", StreetType.SQUARE);
        Location destination = new Street("destination_fucked", StreetType.SQUARE);
        Location.link(start, destination);
        Gateway gateway = start.getGateways().get(0);
        hero.getHeroInteraction().setPosition(start);
        travelEvent = new TravelEvent(gateway);
        //travel end
    }

    @Test
    void handleEvent() {
        //Equip test
        heroChannel.handleEvent(equipEvent);
        String expectName = "Mock bow";
        String assertName = hero.getWeapon().getName();
        assertEquals(expectName, assertName);

        //Get ready test
        hero.getHeroInteraction().setStatus(HeroInteraction.HeroStatus.IN_COMBAT);
        heroChannel.handleEvent(getReadyEvent);
        HeroInteraction.HeroStatus expectStatus = HeroInteraction.HeroStatus.READY;
        HeroInteraction.HeroStatus assertStatus = HeroInteraction.HeroStatus.READY;
        assertEquals(expectStatus, assertStatus);

        //Sign in test
        heroChannel.handleEvent(signInEvent);
        String expectCreature = "Mockster";
        String assertCreature = hero.getHeroInteraction().getEnemyQueue().peek().getName();
        assertEquals(expectCreature, assertCreature);

        //Test travel
        heroChannel.handleEvent(travelEvent);
        String expectLocation = "destination_fucked";
        String assertLocation = hero.getHeroInteraction().getPosition().getName();
        assertEquals(expectLocation, assertLocation);

    }

}