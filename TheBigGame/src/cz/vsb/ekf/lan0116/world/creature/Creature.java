package cz.vsb.ekf.lan0116.world.creature;

public abstract class Creature {

    private final String name;
    private float currentLifeEssence;
    private float maxLifeEssence;
    private float attack;
    private float defense;
    private float vitality;


    public Creature(String name, int maxLifeEssence, int attack, int defense) {
        this.name = name;
        this.maxLifeEssence = maxLifeEssence;
        this.currentLifeEssence = getMaxLifeEssence();
        this.attack = attack;
        this.defense = defense;
        this.vitality = this.getMaxLifeEssence() + this.getDefense();
    }

    public String getName() {
        return name;
    }

    public final boolean isAlive() {
        return (this.currentLifeEssence > 0);
    }

    public float getCurrentLifeEssence() {
        return currentLifeEssence;
    }

    public void setCurrentLifeEssence(float currentLifeEssence) {
        this.currentLifeEssence = currentLifeEssence;
    }

    public float getMaxLifeEssence() {
        return maxLifeEssence;
    }

    public void setMaxLifeEssence(float maxLifeEssence) {
        this.maxLifeEssence = maxLifeEssence;
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
        return this.currentLifeEssence + this.defense;
    }

    public void setVitality(float vitality) {
        this.vitality = vitality;
    }

    public void inflictDamage(float damage) {
        currentLifeEssence = currentLifeEssence - damage;
        if (currentLifeEssence < 0) currentLifeEssence = 0;
    }
}
