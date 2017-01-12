package cz.vsb.ekf.lan0116.world.creature;

import cz.vsb.ekf.lan0116.combat.Attack;

import java.util.List;

public class Beast extends Creature {
    public Beast(String name, CreatureClass clazz, float maxLifeEssence, float maxStamina, float attackPower,
                 float defense) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense);
    }

    public Beast(String name, CreatureClass clazz, float maxLifeEssence, float maxStamina, float attackPower,
                 float defense, Attack... attacks) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense, attacks);
    }

    public Beast(String name, CreatureClass clazz, float maxLifeEssence, float maxStamina, float attackPower,
                 float defense, List<Attack> attacks) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense, attacks);
    }

    public Beast(String creatureId) {
        super(creatureId);
    }
}
