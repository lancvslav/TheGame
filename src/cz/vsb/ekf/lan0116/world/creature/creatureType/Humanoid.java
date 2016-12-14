package cz.vsb.ekf.lan0116.world.creature.creatureType;

import cz.vsb.ekf.lan0116.util.ListManageUtil;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.item.Weapon;

public class Humanoid extends Creature {

    private Weapon weapon;

    public Humanoid(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense);
    }

    public Humanoid(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense,
                    String weaponId, String... attacks) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense, attacks);
        this.setWeapon(ListManageUtil.getWeaponObject(weaponId));
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public float getAttackPower() {
        return this.getWeapon() != null ? (super.getAttackPower() + this.getWeapon().getDamageRatio()) :
                super.getAttackPower();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}