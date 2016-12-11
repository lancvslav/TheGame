package cz.vsb.ekf.lan0116.world.creature.hero;

public class Ranger extends Hero {

    private float agility;

    public Ranger(String name) {
        super(name, HeroClass.RANGER);
        this.agility = HeroClass.RANGER.getDamage();
    }

    @Override
    public float getAttackPower() {
        return this.getAgility() + this.getWeapon().getDamage();
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
