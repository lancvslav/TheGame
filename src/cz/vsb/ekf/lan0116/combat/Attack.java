package cz.vsb.ekf.lan0116.combat;

public class Attack {

    private String name;
    private AttackProperty property;
    private float penetration;
    private float multiplier;
    private float staminaConsumption;

    public Attack(String name, AttackProperty property, float penetration, float multiplier, float staminaConsumption) {
        this.name = name;
        this.property = property;
        this.penetration = penetration;
        this.multiplier = multiplier;
        this.staminaConsumption = staminaConsumption;
    }

    public String getName() {
        return name;
    }

    public AttackProperty getProperty() {
        return property;
    }

    public float getPenetration() {
        return penetration;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public float getStaminaConsumption() {
        return staminaConsumption;
    }
}
