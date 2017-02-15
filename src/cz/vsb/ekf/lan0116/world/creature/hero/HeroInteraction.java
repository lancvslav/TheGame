package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.location.Location;

import java.util.Queue;

public class HeroInteraction {

    private Location position;
    private Creature currentEnemy;
    private Queue<Creature> enemyQueue;
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
        return this.getEnemyQueue().peek();
    }

//    public Creature pullNextEnemy() {
//        return this.getEnemyQueue().poll();
//    }

    public Queue<Creature> getEnemyQueue() {
        return enemyQueue;
    }

    public void setEnemyQueue(Queue<Creature> enemyQueue) {
        this.enemyQueue = enemyQueue;
    }

    public HeroStatus getStatus() {
        return status;
    }

    public void setStatus(HeroStatus status) {
        this.status = status;
    }

    public enum HeroStatus {
        IN_COMBAT,
        INTERACTING,
        READY,
        RESTING,
        SHOPPING,
        /**/;
    }
}
