package cz.vsb.ekf.lan0116.world.creature.enemy;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class Enemy extends Creature {

    public Enemy(String name) {
        super(name, 10, 10, 10, 10, "attack.hit");
    }

    public Enemy(String name, float maxHp, float maxStamina, float attack, float defense, String attackId) {
        super(name, maxHp, maxStamina, attack, defense, attackId);
    }

    public Enemy(String name, float maxHp, float maxStamina, float attack, float defense, String... attacksId) {
        super(name, maxHp, maxStamina, attack, defense, attacksId);
    }
}
