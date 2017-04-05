package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.combat.Tournament;
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
    private HeroChannel heroChannel;

    @BeforeEach
    void setUp() {
        hero = new Ranger("Tester");
        heroChannel = new HeroChannel(hero, null, null);
    }

    @Test
    void testEquipEvent_IsEquipped() {
        Weapon weapon = new Weapon("Mock bow", WeaponType.RANGED, 1, 1, null);
        hero.getInventory().addItem(weapon);
        EquipEvent equipEvent = new EquipEvent(weapon);

        heroChannel.handleEvent(equipEvent);

        String expectName = "Mock bow";
        String assertName = hero.getWeapon().getName();
        assertEquals(expectName, assertName);
    }


    @Test
    void testGetReadyEvent_IsReady() {
        GetReadyEvent getReadyEvent = new GetReadyEvent();
        hero.getHeroInteraction().setStatus(HeroInteraction.HeroStatus.IN_COMBAT);

        heroChannel.handleEvent(getReadyEvent);

        HeroInteraction.HeroStatus expectStatus = HeroInteraction.HeroStatus.READY;
        HeroInteraction.HeroStatus assertStatus = HeroInteraction.HeroStatus.READY;
        assertEquals(expectStatus, assertStatus);
    }

    @Test
    void testSignInEvent_HasEnemy() {
        Creature enemy = new Creature("Mockster", CreatureClass.WARRIOR, 10, 10, 10, 10);
        List<Creature> enemyList = new ArrayList<>();
        enemyList.add(enemy);
        Tournament tournament = new Tournament("Testament", enemyList);
        SignInEvent signInEvent = new SignInEvent(tournament);

        heroChannel.handleEvent(signInEvent);

        String expectCreature = "Mockster";
        String assertCreature = hero.getHeroInteraction().getEnemyQueue().peek().getName();
        assertEquals(expectCreature, assertCreature);
    }

    @Test
    void testTravelEvent_reachedDestination() {
        Location start = new Street("start", StreetType.SQUARE);
        Location destination = new Street("destination_fucked", StreetType.SQUARE);
        Location.link(start, destination);
        Gateway gateway = start.getGateways().get(0);
        hero.getHeroInteraction().setPosition(start);
        TravelEvent travelEvent = new TravelEvent(gateway);

        heroChannel.handleEvent(travelEvent);

        String expectLocation = "destination_fucked";
        String assertLocation = hero.getHeroInteraction().getPosition().getName();
        assertEquals(expectLocation, assertLocation);
    }
}