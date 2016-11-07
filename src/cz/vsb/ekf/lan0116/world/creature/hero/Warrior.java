package cz.vsb.ekf.lan0116.world.creature.hero;

public class Warrior extends Hero {

    private float strength;

    public Warrior(String name) {
        super(name, HeroClass.WARRIOR);
        this.strength = HeroClass.WARRIOR.getDamage();
    }

    @Override
    public float getAttack() {
        return this.getStrength() + this.getWeapon().getDamage();
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