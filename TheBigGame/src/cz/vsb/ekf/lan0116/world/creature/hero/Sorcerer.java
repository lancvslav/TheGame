package cz.vsb.ekf.lan0116.world.creature.hero;

public class Sorcerer extends Hero {

    private int intelligence;

    public Sorcerer(String name) {
        super(name, HeroClass.SORCERER);
        this.intelligence = HeroClass.SORCERER.getDamage();
    }

    @Override
    public float getAttack() {
        return this.getIntelligence() + this.getWeapon().getDamage();
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Wise caster, called " + this.getName() +
                " has " + this.getCurrentLifeEssence() + " essence of life and is wielding "+ this.getWeapon().getName();
    }

}
