package cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.combatHandling;

import cz.vsb.ekf.lan0116.eventSystem.Response;
import cz.vsb.ekf.lan0116.eventSystem.eventProcessingNetwork.eventAgent.CombatChannel;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.InflictDamageEvent;
import cz.vsb.ekf.lan0116.eventSystem.failures.FightFailure;
import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyAttack;
import cz.vsb.ekf.lan0116.eventSystem.events.combat.FightRoundEvent;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;
import cz.vsb.ekf.lan0116.world.creature.hero.Hero;
import cz.vsb.ekf.lan0116.world.creature.hero.attack.HeroAttack;

public class FightRoundHandle {

    private final CombatChannel combatChannel;
    private final Hero hero;
    private final HeroAttack heroAttack;
    private final Enemy enemy;
    private float stolenEssence;
    private float damageToEnemy;
    private float damageToHero;

    public FightRoundHandle(FightRoundEvent event, HeroAttack heroAttack, CombatChannel combatChannel) {
        this.hero = event.getHero();
        this.combatChannel = combatChannel;
        this.heroAttack = heroAttack;
        this.enemy = event.getEnemy();
    }

    public Response handleRound() {
        float hitPower;

        hitPower = hero.getAttack() * (heroAttack.getDamageMultiplier());

        damageToEnemy = defending(enemy, hitPower);

        this.combatChannel.handleEvent(new InflictDamageEvent(enemy, damageToEnemy));

        if (!enemy.isAlive()) return new Response(FightFailure.ENEMY_DEAD);

        if (enemy.getCurrentStamina() >= enemy.getSpecialAttack().getStaminaConsumption()) {
            damageToHero = this.handleEnemyAttack(enemy.getAttack(), enemy.getSpecialAttack());
        } else {
            damageToHero = this.defending(hero, hitPower);
        }
        this.combatChannel.handleEvent(new InflictDamageEvent(hero, damageToHero));

        if (!hero.isAlive()) return new Response(FightFailure.HERO_DEAD);

        return Response.SUCCESS;
    }

    private float defending(Creature beingAttacked, float hitPower) {
        float damageDone = ((hitPower) / (1 + (beingAttacked.getDefense() / 100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }

    private float handleEnemyAttack(float hitPower, EnemyAttack attack) {
        float damagePortion;
        switch (attack) {
            case BACKSTAB:
                return this.defending(hero, (hitPower * 2));
            case BLEED:
                damagePortion = this.defending(hero, hitPower);
                damagePortion += this.defending(hero, (hitPower / 2));
                return damagePortion;
            case CRUSHING_BLOW:
                return ((hitPower) / (1 + ((hero.getDefense() / 0.7f) / 100)));
            case HIT:
                return this.defending(hero, hitPower);
            case LIFESTEAL:
                damagePortion = this.defending(hero, hitPower);
                this.stolenEssence = damagePortion * 0.3f;
                return damagePortion;
            case MAGIC_BOLT:
                return this.defending(hero, (hitPower * 1.2f));
            case SHOOT:
                this.defending(hero, (hitPower * 2));
            default:
                return this.defending(hero, hitPower);
        }
    }

}

//CHECKING, WHETHER ENEMY SHOULD START FIRST
//        boolean enemyStarts = enemy.getSpecialAttack().equals(EnemyAttack.INITIATIVE);
//        if (enemyStarts) {
//            fighter0 = enemy;
//            fighter1 = hero;
//        }


//        while (heroHandling.isAlive() && enemy.isAlive()) {
//            Fight combat = new Fight(heroHandling, enemy);
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new InflictDamageEvent(enemy, combat.attacking(heroHandling, enemy)));
//            System.out.println("You hit with " +
//                    this.get(heroHandling.getWeapon().getName()) + " for: " + combat.attacking(heroHandling, enemy));
//            TextUtil.sleep(90);
//            if (!enemy.isAlive()) {
//                System.out.println("Enemy died.");
//                TextUtil.sleep(50);
//                return;
//            }
//
//            this.getContext().getDeprecatedHandler().
//                    handleEvent(new InflictDamageEvent(heroHandling, combat.attacking(enemy, heroHandling)));
//            TextUtil.sleep(90);
//            System.out.println("Enemy hit for " + combat.attacking(enemy, heroHandling) +
//                    " dmg. Your life essence status: " + heroHandling.getCurrentLifeEssence());
//            new CreatureStatusUi(this.getContext(), heroHandling).show();
//            TextUtil.sleep(20);
//        }
//
//        if (!heroHandling.isAlive()) {
//            TextUtil.sleep(90);
//            System.out.println("You died");
//        }





