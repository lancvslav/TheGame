package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;
import cz.vsb.ekf.lan0116.world.location.Location;

import java.util.Queue;

public class HeroInteraction {

    private Location position;
    private Creature currentEnemy;
    private Queue<Enemy> enemyQueue;
    private HeroStatus status;

    public HeroInteraction() {
    }

    public Location getPosition() {
        return position;
    }

    public void setPosition(Location position) {
        this.position = position;
    }

    public Creature getCurrentEnemy() {
        return currentEnemy;
    }

    public void setCurrentEnemy(Creature currentEnemy) {
        this.currentEnemy = currentEnemy;
    }

    public Queue<Enemy> getEnemyQueue() {
        return enemyQueue;
    }

    public void setEnemyQueue(Queue<Enemy> enemyQueue) {
        this.enemyQueue = enemyQueue;
    }

    public HeroStatus getStatus() {
        return status;
    }

    public void setStatus(HeroStatus status) {
        this.status = status;
    }

    public enum HeroStatus {
        READY,
        IN_COMBAT,
        RESTING,
        SHOPPING,
        /**/;
    }
}
