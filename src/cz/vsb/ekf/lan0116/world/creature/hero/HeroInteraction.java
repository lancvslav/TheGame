package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.humanoid.Humanoid;
import cz.vsb.ekf.lan0116.world.location.Location;

import java.util.Queue;

/**
 * this class should help to brief Hero class, so it doesn't contain every possible information about hero, which might
 * be thorough the game needed
 */
public class HeroInteraction {

    private Location position;
    private Queue<Creature> enemyQueue;
    private HeroStatus status;
    private Humanoid subjectOfInteraction;

    HeroInteraction() {
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

    public Humanoid getSubjectOfInteraction() {
        return subjectOfInteraction;
    }

    public void setSubjectOfInteraction(Humanoid subjectOfInteraction) {
        this.subjectOfInteraction = subjectOfInteraction;
    }

    /**
     * enum which values stands for status player might be in, it helps to determine which screen should be printed
     */
    public enum HeroStatus {
        IN_COMBAT,
        INTERACTING,
        IN_TOURNAMENT,
        READY,
        RESTING,
        SHOPPING,
        TALKING,
        /**/;
    }
}
