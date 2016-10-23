package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.util.Localization;

public class Warrior extends Hero {

    private int strength;

    public Warrior(String name, Localization localization) {
        super(name, HeroClass.WARRIOR, localization);
        this.strength = HeroClass.WARRIOR.getDamage();
    }

    @Override
    public float getAttack() {
        return this.getStrength() + this.getWeapon().getDamage();
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return this.getLocalization().get("toString.warrior.brave") + " " + this.getName() + ", "
                + this.getLocalization().get("toString.hero.has") + " " + this.getCurrentLifeEssence()
                + " " + this.getLocalization().get("toString.hero.essence_wields")
                + this.getLocalization().get(this.getWeapon().getName());
    }

}
