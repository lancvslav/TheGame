package cz.vsb.ekf.lan0116.world.creature.enemy;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class EnemyDeprecated extends Creature {

    public EnemyDeprecated(String name, float maxHp, float maxStamina, float attack, float defense, String attackId) {
        super(name, maxHp, maxStamina, attack, defense, attackId);
    }

    public EnemyDeprecated(String name, float maxHp, float maxStamina, float attack, float defense, String... attacksId) {
        super(name, maxHp, maxStamina, attack, defense, attacksId);
    }
}
