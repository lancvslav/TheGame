package cz.vsb.ekf.lan0116.world.creature.humanoid;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.world.creature.Creature;
import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.item.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Humanoid extends Creature {

    private Weapon weapon;
    private Dialogue dialogue;

    public Humanoid(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense);
    }

    public Humanoid(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense, Weapon weapon) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense);
        this.weapon = weapon;
    }

    public Humanoid(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense, Dialogue dialogue) {
        this(name, clazz, maxLifeEssence, maxStamina, attackPower, defense);
        this.dialogue = dialogue;
    }

    public Humanoid(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense, Weapon weapon, Dialogue dialogue) {
        this(name, clazz, maxLifeEssence, maxStamina, attackPower, defense, weapon);
        this.dialogue = dialogue;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Dialogue getDialogue() {
        return dialogue;
    }

    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }

    @Override
    public float getAttackPower() {
        return this.getWeapon() != null ? (super.getAttackPower() + this.getWeapon().getDamageRatio()) :
                super.getAttackPower();
    }

    @Override
    public List<Attack> getAttacks() {
        List<Attack> list = new ArrayList<>();
        if (weapon != null) {
            list.addAll(weapon.getMoveSet());
        }
        list.addAll(super.getAttacks());
        return list;
    }
}
