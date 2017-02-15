package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.type.ArenaType;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends Location {

    private List<? extends Creature> enemyList;

    /**
     * Tournament loads from .txt enemies based of type given in parameter
     */
    public Tournament(List<? extends Creature> enemyList) {
        super("arena", ArenaType.TOURNAMENT);
        this.enemyList = new ArrayList<>();
        this.enemyList = enemyList;
    }

    public List<? extends Creature> getEnemyList() {
        return enemyList;
    }
}
