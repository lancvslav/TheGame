package cz.vsb.ekf.lan0116.world.creature.hero;

import cz.vsb.ekf.lan0116.util.Localization;

public class Sorcerer extends Hero {

    private float intelligence;

    public Sorcerer(String name, Localization localization) {
        super(name, HeroClass.SORCERER, localization);
        this.intelligence = HeroClass.SORCERER.getDamage();
    }

    @Override
    public float getAttack() {
        return this.getIntelligence() + this.getWeapon().getDamage();
    }

    public float getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(float intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return this.getLocalization().get("toString.sorcerer.brave") + " " + this.getName() + ", "
                + this.getLocalization().get("toString.hero.has") + " " + this.getCurrentLifeEssence()
                + " " + this.getLocalization().get("toString.hero.essence_wields")
                + this.getLocalization().get(this.getWeapon().getName());
    }

}
