package cz.vsb.ekf.lan0116.world.creature.enemy;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class Enemy extends Creature {

    private final Enum specialAttack;

    public Enemy(String name) {
        super(name, 10, 10, 10, 10);
        this.specialAttack = EnemyAttackDeprecated.HIT;
    }

    public Enemy(String name, float maxHp, float maxStamina, float attack, float defense, Enum specialAttack) {
        super(name, maxHp, maxStamina, attack, defense);
        this.specialAttack = specialAttack;
    }

    public EnemyAttackDeprecated getSpecialAttack() {
        return (EnemyAttackDeprecated) specialAttack;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
