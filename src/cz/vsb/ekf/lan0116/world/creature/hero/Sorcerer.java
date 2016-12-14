package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.world.creature.CreatureClass;

public class Sorcerer extends Hero {

    private float intelligence;

    public Sorcerer(String name) {
        super(name, CreatureClass.SORCERER);
        this.intelligence = CreatureClass.SORCERER.getDamage();
    }

    @Override
    public float getAttackPower() {
        return this.getIntelligence() + this.getWeapon().getDamageRatio();
    }

    public float getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(float intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Only for testing:";
    }

}
