package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.combat.EnemyAtacks;
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

        float hitPower;

//        //CHECKING, WHETHER ENEMY SHOULD START FIRST
//        boolean enemyStarts = enemy.getSpecialAttack().equals(EnemyAtacks.INITIATIVE);
//        if (enemyStarts) {
//            fighter0 = enemy;
//            figter1 = hero;
//        }

        hitPower = hero.getAttack();

        


        public float defending ( float hitPower){
            float damageDone = ((hitPower) / (1 + (defender.getDefense() / 100)));
            if (damageDone > 0) {
                return damageDone;
            } else {
                return 0;
            }
        }
//        while (heroHandling.isAlive() && enemy.isAlive()) {
//            Fight fight = new Fight(heroHandling, enemy);
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new InflictDamageEvent(enemy, fight.attacking(heroHandling, enemy)));
//            System.out.println("You hit with " +
//                    this.get(heroHandling.getWeapon().getName()) + " for: " + fight.attacking(heroHandling, enemy));
//            TextUtil.sleep(90);
//            if (!enemy.isAlive()) {
//                System.out.println("Enemy died.");
//                TextUtil.sleep(50);
//                return;
//            }
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new InflictDamageEvent(heroHandling, fight.attacking(enemy, heroHandling)));
//            TextUtil.sleep(90);
//            System.out.println("Enemy hit for " + fight.attacking(enemy, heroHandling) +
//                    " dmg. Your life essence status: " + heroHandling.getCurrentLifeEssence());
//            new CreatureStatusUi(this.getContext(), heroHandling).show();
//            TextUtil.sleep(20);
//        }
//
//        if (!heroHandling.isAlive()) {
//            TextUtil.sleep(90);
//            System.out.println("You died");
//        }


    }

}
