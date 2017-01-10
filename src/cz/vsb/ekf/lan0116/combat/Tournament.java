package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.location.Location;
import cz.vsb.ekf.lan0116.world.location.type.ArenaType;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends Location {

    private List<Creature> enemyList;

    /**
     * Tournament loads from .txt enemies based of type given in parameter
     */
    public Tournament(int tournamentType) {
        super("arena", ArenaType.TOURNAMENT);
        this.enemyList = new ArrayList<>();
        enemyList = ListManageUtil.getCreatures(ResourceUtil.getResource(ResourceType.ARENA_ENEMY,
                ("arena" + String.valueOf(tournamentType))));
    }

    public List<Creature> getEnemyList() {
        return enemyList;
    }
}
