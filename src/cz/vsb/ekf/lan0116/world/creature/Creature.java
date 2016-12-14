package cz.vsb.ekf.lan0116.world.creature;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.util.ListManageUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Creature {

    private final String name;
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
        this.currentStamina = this.getMaxStamina();
        this.currentLifeEssence = this.getMaxLifeEssence();
        this.attackPower = attackPower;
        this.defense = defense;
        attacks = new ArrayList<>();
    }

    public Creature(String name, CreatureClass clazz,
                    float maxLifeEssence, float maxStamina, float attackPower, float defense, String... attacks) {
        this.name = name;
        this.clazz = clazz;
        this.maxLifeEssence = maxLifeEssence;
        this.maxStamina = maxStamina;
        this.currentStamina = this.getMaxStamina();
        this.currentLifeEssence = this.getMaxLifeEssence();
        this.attackPower = attackPower;
        this.defense = defense;
        this.attacks = ListManageUtil.attackList(Arrays.asList(attacks));
    }

    public String getName() {
        return name;
    }

    public CreatureClass getClazz() {
        return clazz;
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
}
