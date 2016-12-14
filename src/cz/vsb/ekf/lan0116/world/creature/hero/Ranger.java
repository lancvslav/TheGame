package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.creature.CreatureClass;

public class Ranger extends Hero {

    private float agility;

    public Ranger(String name) {
        super(name, CreatureClass.RANGER);
        this.agility = CreatureClass.RANGER.getDamage();
    }

    @Override
    public float getAttackPower() {
        return this.getAgility() + this.getWeapon().getDamageRatio();
    }

    public float getAgility() {
        return agility;
    }

    public void setAgility(float agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "Only for testing:";
    }

}
