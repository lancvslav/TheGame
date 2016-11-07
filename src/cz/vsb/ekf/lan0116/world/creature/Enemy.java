package cz.vsb.ekf.lan0116.world.creature;

import cz.vsb.ekf.lan0116.combat.EnemyAtacks;

public class Enemy extends Creature {

    private final Enum specialAttack;

    public Enemy(String name) {
        super(name, 10, 10, 10);
        this.specialAttack = EnemyAtacks.HIT;
    }

    public Enemy(String name, int maxHp, int attack, int defense, Enum specialAttack) {
        super(name, maxHp, attack, defense);
        this.specialAttack = specialAttack;
    }

    public EnemyAtacks getSpecialAttack() {
        return (EnemyAtacks) specialAttack;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
