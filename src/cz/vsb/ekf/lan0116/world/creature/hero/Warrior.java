package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.creature.CreatureClass;

public class Warrior extends Hero {

    private float strength;

    public Warrior(String name) {
        super(name, CreatureClass.WARRIOR);
        this.strength = CreatureClass.WARRIOR.getDamage();
    }

    @Override
    public float getAttackPower() {
        return this.getStrength() + this.getWeapon().getDamageRatio();
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Only for testing:";
    }

}
