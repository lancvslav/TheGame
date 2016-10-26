package cz.vsb.ekf.lan0116.world.creature;

import cz.vsb.ekf.lan0116.combat.EnemyAttack;

public class Enemy extends Creature {

    private final Enum specialAttack;

    public Enemy(String name) {
        super(name, 10, 10, 10);
        this.specialAttack = EnemyAttack.HIT;
    }

    public Enemy(String name, int maxHp, int attack, int defense, Enum specialAttack) {
        super(name, maxHp, attack, defense);
        this.specialAttack = specialAttack;
    }

    public EnemyAttack getSpecialAttack() {
        return (EnemyAttack) specialAttack;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
