package cz.vsb.ekf.lan0116.world.creature;

public abstract class Creature {

    private final String name;
    private float currentLifeEssence;
    private float maxLifeEssence;
    private float currentStamina;
    private float maxStamina;
    private float attack;
    private float defense;


    public Creature(String name, float maxLifeEssence, float maxStamina, float attack, float defense) {
        this.name = name;
        this.maxLifeEssence = maxLifeEssence;
        this.maxStamina = maxStamina;
        this.currentStamina = this.getMaxStamina();
        this.currentLifeEssence = this.getMaxLifeEssence();
        this.attack = attack;
        this.defense = defense;
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

    public float getCurrentStamina() {
        return currentStamina;
    }

    public void setCurrentStamina(float currentStamina) {
        this.currentStamina = currentStamina;
    }

    public float getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(float maxStamina) {
        this.maxStamina = maxStamina;
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

    public void heal(float healAmount) {
        float ableToHeal = this.getMaxLifeEssence() - this.getCurrentLifeEssence();
        if (healAmount > ableToHeal) {
            this.setCurrentLifeEssence(this.getMaxLifeEssence());
        } else {
            this.setCurrentLifeEssence(this.getCurrentLifeEssence() + healAmount);
        }
    }

    public void inflictDamage(float damage) {
        currentLifeEssence = currentLifeEssence - damage;
        if (currentLifeEssence < 0) currentLifeEssence = 0;
    }
}
