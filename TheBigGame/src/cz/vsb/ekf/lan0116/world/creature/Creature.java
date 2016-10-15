package cz.vsb.ekf.lan0116.world.creature;

public abstract class Creature {

    private final String name;
    /**
     * Life essence
     */
    private float currentHp;
    private float maxHp;
    private float attack;
    private float defense;
    private float vitality;


    public Creature(String name, int maxHp, int attack, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = getMaxHp();
        this.attack = attack;
        this.defense = defense;
        this.vitality = this.getMaxHp() + this.getDefense();
    }

    public String getName() {
        return name;
    }

    public final boolean isAlive() {
        return (this.currentHp > 0);
    }

    public float getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(float currentHp) {
        this.currentHp = currentHp;
    }

    public float getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(float maxHp) {
        this.maxHp = maxHp;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public float getVitality() {
        return this.currentHp + this.defense;
    }

    public void setVitality(float vitality) {
        this.vitality = vitality;
    }

    public void inflictDamage(float damage) {
        currentHp = currentHp - damage;
    }
}
