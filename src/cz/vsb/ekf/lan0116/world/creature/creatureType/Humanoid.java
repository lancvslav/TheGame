package cz.vsb.ekf.lan0116.world.creature.creatureType;

import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.item.Weapon;

public class Humanoid extends Creature {

    private Weapon weapon;

    public Humanoid(String name, float maxLifeEssence, float maxStamina, float attackPower, float defense) {
        super(name, maxLifeEssence, maxStamina, attackPower, defense);
    }

    public Humanoid(String name, float maxLifeEssence, float maxStamina, float attackPower, float defense,
                    String... attacks) {
        super(name, maxLifeEssence, maxStamina, attackPower, defense, attacks);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
