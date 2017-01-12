package cz.vsb.ekf.lan0116.world.creature;

import cz.vsb.ekf.lan0116.combat.Attack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Creature {

    private String name;
    private CreatureClass clazz;
    private float currentLifeEssence;
    private float maxLifeEssence;
    private float currentStamina;
    private float maxStamina;
    private float attackPower;
    private float defense;
    private List<Attack> attacks;


    public Creature(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense) {
        this.name = name;
        this.clazz = clazz;
        this.maxLifeEssence = maxLifeEssence;
        this.maxStamina = maxStamina;
        this.currentLifeEssence = this.getMaxLifeEssence();
        this.currentStamina = this.getMaxStamina();
        this.attackPower = attackPower;
        this.defense = defense;
        this.attacks = new ArrayList<>();
        this.attacks.add(Attack.FEEBLE_ATTACK);
    }

    public Creature(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense, Attack... attacks) {
        this.name = name;
        this.clazz = clazz;
        this.maxLifeEssence = maxLifeEssence;
        this.maxStamina = maxStamina;
        this.currentLifeEssence = this.getMaxLifeEssence();
        this.currentStamina = this.getMaxStamina();
        this.attackPower = attackPower;
        this.defense = defense;
        this.attacks = new ArrayList<>(Arrays.asList(attacks));
        this.attacks.add(Attack.FEEBLE_ATTACK);
    }

    public Creature(String name, CreatureClass clazz, float maxLifeEssence, float maxStamina, float attackPower,
                    float defense, List<Attack> attacks) {
        this.name = name;
        this.clazz = clazz;
        this.maxLifeEssence = maxLifeEssence;
        this.maxStamina = maxStamina;
        this.currentLifeEssence = this.getMaxLifeEssence();
        this.currentStamina = this.getMaxStamina();
        this.attackPower = attackPower;
        this.defense = defense;
        this.attacks = attacks;
        this.attacks.add(Attack.FEEBLE_ATTACK);
    }

//    public Creature(String creatureId) {
//        Creature creature = ObjectFactory.cloneCreature(creatureId);
//        this.name = creature.getName();
//        this.clazz = creature.getClazz();
//        this.maxLifeEssence = creature.getMaxLifeEssence();
//        this.maxStamina = creature.getMaxStamina();
//        this.currentLifeEssence = this.getMaxLifeEssence();
//        this.currentStamina = this.getMaxStamina();
//        this.attackPower = creature.getAttackPower();
//        this.defense = creature.getDefense();
//        this.attacks = creature.getAttacks();
//        this.attacks.add(Attack.FEEBLE_ATTACK);
//    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public CreatureClass getClazz() {
        return clazz;
    }

    protected void setClazz(CreatureClass clazz) {
        this.clazz = clazz;
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

    public void addCurrentLifeEssence(float addedHealth) {
        this.currentLifeEssence += addedHealth;
        currentLifeEssence = Math.min(maxLifeEssence, currentLifeEssence + addedHealth);
    }

    public void decreaseCurrentLifeEssence(float damage) {
        this.currentLifeEssence -= damage;
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

    public void addCurrentStamina(float addedStamina) {
        currentStamina = Math.min(maxStamina, currentStamina + addedStamina);
    }

    public void decreaseCurrentStamina(float consumedStamina) {
        if (consumedStamina > currentStamina) {
            throw new IllegalArgumentException("Cannot remove more stamina than there is currently");
        }
        currentStamina -= consumedStamina;
    }

    public float getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(float maxStamina) {
        this.maxStamina = maxStamina;
    }

    public float getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(float attackPower) {
        this.attackPower = attackPower;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void learnAttack(Attack... attacks) {
        for (Attack attack : attacks) {
            this.attacks.add(attack);
        }
    }

    public void learnAttack(List<Attack> attacks) {
        for (Attack attack : attacks) {
            this.attacks.add(attack);
        }
    }
}
