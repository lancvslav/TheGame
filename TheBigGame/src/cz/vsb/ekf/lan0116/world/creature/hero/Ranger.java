package cz.vsb.ekf.lan0116.world.creature.hero;

public class Ranger extends Hero {

    private int agility;

    public Ranger(String name) {
        super(name, HeroClass.RANGER);
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
        return "Swift ranger, called " + this.getName() +
                " has " + this.getCurrentLifeEssence() + " essence of life and is wielding " + this.getWeapon().getName();
    }

}
