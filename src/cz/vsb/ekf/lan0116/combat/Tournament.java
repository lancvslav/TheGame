package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.world.creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private final List<? extends Creature> enemyList;

    private final String name;

    /**
     * Tournament loads from .txt enemies based of type given in parameter
     */
    public Tournament(String name, List<? extends Creature> enemyList) {
        this.name = name;
        this.enemyList = new ArrayList<>(enemyList);
    }

    public String getName() {
        return name;
    }

    public List<? extends Creature> getEnemyList() {
        return enemyList;
    }
}
