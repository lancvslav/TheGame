package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.GetReadyEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.SignInEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.TravelEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.items.EquipEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.TalkEvent;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.npc.shoping.InitiateDialogueEvent;
import cz.vsb.ekf.lan0116.eventSystem.serverEvents.ResponseChannel;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.HeroInteraction;
import cz.vsb.ekf.lan0116.world.creature.hero.Ranger;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Dialogue;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
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
    private Humanoid sameClazz;
    private HeroChannel heroChannel;

    @BeforeEach
    void setUp() {
        hero = new Ranger("Tester");
        sameClazz = new Humanoid("sameClazz", CreatureClass.RANGER, 1, 1, 1, 1);
        ResponseChannel responseChannel = new ResponseChannel();
        heroChannel = new HeroChannel(hero, null, responseChannel);
    }

    @Test
    void testEquipEvent_IsEquipped() {
        Weapon weapon = new Weapon("Mock bow", WeaponType.RANGED, 1, 1, null);
        hero.getInventory().addItem(weapon);
        EquipEvent equipEvent = new EquipEvent(weapon);

        heroChannel.handleEvent(equipEvent);

        String expectName = "Mock bow";
        String actualName = hero.getWeapon().getName();
        assertEquals(expectName, actualName);
    }


    @Test
    void testGetReadyEvent_IsReady() {
        GetReadyEvent getReadyEvent = new GetReadyEvent();
        hero.getHeroInteraction().setStatus(HeroInteraction.HeroStatus.IN_COMBAT);

        heroChannel.handleEvent(getReadyEvent);

        HeroInteraction.HeroStatus expectStatus = HeroInteraction.HeroStatus.READY;
        HeroInteraction.HeroStatus actualStatus = hero.getHeroInteraction().getStatus();
        assertEquals(expectStatus, actualStatus);
    }

    @Test
    void testInitiateDialogue_friendly_indexChange() {
        List<String> friendly = new ArrayList<>();
        List<String> neutral = new ArrayList<>();
        friendly.add("friendly0");
        friendly.add("friendly1");
        friendly.add("friendly2");
        neutral.add("neutral");

        Dialogue mockDialogue = new Dialogue(friendly, neutral);
        sameClazz.setDialogue(mockDialogue);

        heroChannel.handleEvent(new InitiateDialogueEvent(sameClazz));


        int actualIndex = sameClazz.getDialogue().getFriendlyIndex();
        assertEquals(1, actualIndex);
    }

    @Test
    void testInitiateDialogue_neutral_indexReset() {
        List<String> friendly = new ArrayList<>();
        List<String> neutral = new ArrayList<>();
        friendly.add("friendly0");
        friendly.add("friendly1");
        friendly.add("friendly2");
        neutral.add("neutral");
        Dialogue mockDialogue = new Dialogue(friendly, neutral);
        Humanoid mockNeutral = new Humanoid("neutral", CreatureClass.WARRIOR, 1, 1, 1, 1, mockDialogue);


        heroChannel.handleEvent(new InitiateDialogueEvent(mockNeutral));

        int actualIndex = mockNeutral.getDialogue().getFriendlyIndex();
        assertEquals(0, actualIndex);
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
        String actualCreature = hero.getHeroInteraction().getEnemyQueue().peek().getName();
        assertEquals(expectCreature, actualCreature);
    }

    @Test
    void testSubjectOfInteraction_isProperlySet() {
        heroChannel.handleEvent(new TalkEvent(sameClazz));

        String expectName = "sameClazz";
        String actualName = hero.getHeroInteraction().getSubjectOfInteraction().getName();
        assertEquals(expectName, actualName);
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
        String actualLocation = hero.getHeroInteraction().getPosition().getName();
        assertEquals(expectLocation, actualLocation);
    }
}