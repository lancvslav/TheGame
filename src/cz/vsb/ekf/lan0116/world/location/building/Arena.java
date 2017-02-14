package cz.vsb.ekf.lan0116.world.location.building;

import cz.vsb.ekf.lan0116.combat.Tournament;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.location.type.ArenaType;

import java.util.ArrayList;
import java.util.List;

public class Arena extends Building {

    private final List<Tournament> tournaments;

    public Arena(String nameOfLocation, List<List<Creature>> creatureMultipleLists) {
        super(nameOfLocation, ArenaType.ARENA);
        tournaments = new ArrayList<>();
        for (List<Creature> creatureList : creatureMultipleLists) {
            tournaments.add(new Tournament(creatureList));
        }
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }
}
