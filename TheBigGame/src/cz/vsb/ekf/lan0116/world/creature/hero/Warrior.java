package cz.vsb.ekf.lan0116.world.creature.hero;

public class Warrior extends Hero {

    private int strength;

    public Warrior(String name) {
        super(name, HeroClass.WARRIOR);
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
        return "Brave warrior, called " + this.getName() +
                " has " + this.getCurrentLifeEssence() + " essence of life and is wielding " + this.getWeapon().getName();
    }

}
