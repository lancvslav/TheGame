package cz.vsb.ekf.lan0116.world.building;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.world.LocationType;

import java.util.ArrayList;
import java.util.List;

public class Arena extends Building {

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
