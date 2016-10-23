package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.util.Localization;

public class Ranger extends Hero {

    private int agility;

    public Ranger(String name, Localization localization) {
        super(name, HeroClass.RANGER, localization);
        this.agility = HeroClass.RANGER.getDamage();
    }

    @Override
    public float getAttack() {
        return this.getAgility() + this.getWeapon().getDamage();
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        return this.getLocalization().get("toString.ranger.brave") + " " + this.getName() + ", "
                + this.getLocalization().get("toString.hero.has") + " "+ this.getCurrentLifeEssence()
                + " " + this.getLocalization().get("toString.hero.essence_wields")
                + this.getLocalization().get(this.getWeapon().getName());
    }

}
