package cz.vsb.ekf.lan0116.world.location.building;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.world.location.type.ArenaType;

import java.util.List;

public class Arena extends Building {

    private final List<Tournament> tournaments;

    public Arena(String nameOfLocation, List<Tournament> tournaments) {
        super(nameOfLocation, ArenaType.ARENA);
        this.tournaments = tournaments;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }
}
