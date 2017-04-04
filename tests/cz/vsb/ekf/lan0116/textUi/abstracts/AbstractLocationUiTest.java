package cz.vsb.ekf.lan0116.textUi.abstracts;


import cz.vsb.ekf.lan0116.eventSystem.Session;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.EventPublisher;
import cz.vsb.ekf.lan0116.eventSystem.events.hero.TravelEvent;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.Ranger;
import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.street.Street;
import cz.vsb.ekf.lan0116.world.location.type.StreetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractLocationUiTest {

    private Hero hero;
    private Location start;
    private Location destination;
    private EventPublisher publisher;
    private Session session;

    @BeforeEach
    void setUp() {
        hero = new Ranger("Tester");
        start = new Street("start", StreetType.SQUARE);
        destination = new Street("destination_fucked", StreetType.SQUARE);
        Location.link(start, destination);
        hero.getHeroInteraction().setPosition(start);
        publisher = new EventPublisher(hero, null, null);
        session = new Session(publisher, null);
    }

    @Test
    void travel() {
        session.fireEvent(new TravelEvent(start.getGateways().get(0)));
        String expName = "destination_fucked";
        String assertName = hero.getHeroInteraction().getPosition().getName();
        assertEquals(expName,assertName);
    }

}