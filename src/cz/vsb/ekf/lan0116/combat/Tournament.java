package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.util.ResourceType;
import cz.vsb.ekf.lan0116.util.ResourceUtil;
import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyDeprecated;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private List<EnemyDeprecated> enemyDeprecatedList;

    /**
     * Tournament loads from .txt enemies based of type given in parameter
     */
    public Tournament(int tournamentType) {
        this.enemyDeprecatedList = new ArrayList<>();
        enemyDeprecatedList = ListManageUtil.getEnemies(ResourceUtil.getResource(ResourceType.ARENA_ENEMY,
                ("arena" + String.valueOf(tournamentType))));
    }

    public List<EnemyDeprecated> getEnemyDeprecatedList() {
        return enemyDeprecatedList;
    }
}
