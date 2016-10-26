package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.combat.EnemyAttack;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.Enemy;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;

public class FightRoundHandle {

    private final Hero hero;
    private final Enemy enemy;

    public FightRoundHandle(FightRoundEvent event) {
        this.hero = event.getHero();
        this.enemy = event.getEnemy();
    }

    public void handleRound() {

        Creature fighter0 = hero;
        Creature figter1 = enemy;

        //CHECKING, WHETHER ENEMY SHOULD START FIRST
        boolean enemyStarts = enemy.getSpecialAttack().equals(EnemyAttack.INITIATIVE);
        if (enemyStarts == true) {
            fighter0 = enemy;
            figter1 = hero;
        }



    }

}
