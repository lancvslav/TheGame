package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private List<Enemy> enemyList;

    /**
     * Tournament loads from .txt enemies based of type given in parameter
     */
    public Tournament(int tournamentType) {
        this.enemyList = new ArrayList<>();
        enemyList = ListManageUtil.getEnemies(ResourceUtil.getResource(ResourceType.ARENA,
                ("arena" + String.valueOf(tournamentType))));
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }
}
