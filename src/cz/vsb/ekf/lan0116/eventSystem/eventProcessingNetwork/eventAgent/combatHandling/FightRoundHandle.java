package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyAttacks;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.attack.HeroAttacks;

public class FightRoundHandle {

    private final Hero hero;
    private final HeroAttacks heroAttack;
    private final Enemy enemy;

    public FightRoundHandle(FightRoundEvent event, HeroAttacks heroAttack) {
        this.hero = event.getHero();
        this.heroAttack = heroAttack;
        this.enemy = event.getEnemy();
    }

    public void handleRound() {

        float hitPower;


        hitPower = hero.getAttack() * (heroAttack.getDamageMultiplier());

        float damageToEnemy = defending(enemy, hitPower);

        if (!enemy.isAlive()) return;

        hitPower = enemy.getAttack();

        float damageToHero = defending(hero, hitPower);
    }

    private float defending(Creature creature, float hitPower) {
        float damageDone = ((hitPower) / (1 + (creature.getDefense() / 100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }

    private float handleEnemyAttack(float hitPower, EnemyAttacks attack) {
        switch (attack) {
            case BACKSTAB:
                return hitPower * 2;
            case BLEED: return hitPower+(hitPower*0.5f);
            case CRUSHING_BLOW:
            default:
                return hitPower;
        }
    }

}

//CHECKING, WHETHER ENEMY SHOULD START FIRST
//        boolean enemyStarts = enemy.getSpecialAttack().equals(EnemyAttacks.INITIATIVE);
//        if (enemyStarts) {
//            fighter0 = enemy;
//            fighter1 = hero;
//        }


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





