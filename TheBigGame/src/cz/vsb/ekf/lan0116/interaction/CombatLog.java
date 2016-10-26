package cz.vsb.ekf.lan0116.interaction;

import cz.vsb.ekf.lan0116.combat.EnemyAttack;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.hero.attack.HeroAttacks;

public class CombatLog {

    private Creature attacker;
    private Creature target;

    private HeroAttacks heroAttack;
    private EnemyAttack enemyAttack;

    private float heroHitPower;
    private float enemyHitPower;

}
