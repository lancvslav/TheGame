package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Arena extends Location {

    private Hero hero;
    private final List<Tournament> tournaments;


    public Arena(String nameOfLocation) {
        super(nameOfLocation, LocationType.ARENA);
        tournaments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tournaments.add(new Tournament(i));
        }
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }
}
